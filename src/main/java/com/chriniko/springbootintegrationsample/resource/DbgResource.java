package com.chriniko.springbootintegrationsample.resource;

import com.chriniko.springbootintegrationsample.dto.DbgResult;
import com.chriniko.springbootintegrationsample.dto.DrawInfo;
import com.chriniko.springbootintegrationsample.gateway.DbgDrawGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.*;
import java.util.concurrent.*;

@RestController
public class DbgResource {

    private final DbgDrawGateway dbgDrawGateway;
    private final JobManager<DbgResult> dbgResultJobManager;

    @Autowired
    public DbgResource(DbgDrawGateway dbgDrawGateway) {
        this.dbgDrawGateway = dbgDrawGateway;
        dbgResultJobManager = new JobManager<>();
        dbgResultJobManager.monitor();
    }

    @RequestMapping(
            value = "/draw",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody DeferredResult<DbgResult> performFooDraw(@RequestBody DrawInfo drawInfo) {

        DeferredResult<DbgResult> dR = new DeferredResult<>(2000L);

        Future<DbgResult> dbgResultFuture = dbgDrawGateway.performSampleDraw(drawInfo);

        dbgResultJobManager.addJob(dbgResultFuture, dR);

        return dR;
    }

    static class JobManager<T> {

        private final List<Map<Future<T>, DeferredResult<T>>> jobsUnderExecution;
        private final ExecutorService executorService;

        JobManager() {
            this.jobsUnderExecution = new ArrayList<>();

            executorService = Executors.newSingleThreadExecutor();

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    executorService.shutdown();
                    executorService.awaitTermination(10, TimeUnit.SECONDS);

                    if (!executorService.isTerminated()) {
                        executorService.shutdownNow();
                    }

                } catch (Throwable ignored) {
                }
            }));
        }

        void addJob(Future<T> f, DeferredResult<T> dR) {

            Map<Future<T>, DeferredResult<T>> m = new HashMap<>();
            m.put(f, dR);

            this.jobsUnderExecution.add(m);
        }

        void monitor() {
            executorService.submit(() -> {
                for (; ; ) {

                    Iterator<Map<Future<T>, DeferredResult<T>>> iterator = jobsUnderExecution.iterator();

                    while (iterator.hasNext()) {

                        Map<Future<T>, DeferredResult<T>> record = iterator.next();
                        Map.Entry<Future<T>, DeferredResult<T>> entry = record.entrySet().iterator().next();

                        Future<T> key = entry.getKey();
                        DeferredResult<T> value = entry.getValue();

                        if (key.isDone()) {
                            try {
                                System.out.println("Job finished successfully!");
                                value.setResult(key.get());

                                iterator.remove();
                            } catch (ExecutionException error) {
                                System.err.println("Job finished successfully!");
                                value.setErrorResult(error.getCause());

                                iterator.remove();
                                //TODO maybe we should store the failed task in a queue for statistics, investigation, etc.
                            }
                        }
                    }

                    Thread.sleep(200); // Note: for throttling purposes.
                }
            });
        }
    }
}

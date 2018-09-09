package com.chriniko.springbootintegrationsample.infra;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.*;
import java.util.concurrent.*;

public class JobManager<T> {

    private final List<Map<Future<T>, DeferredResult<T>>> jobsUnderExecution;
    private final ExecutorService executorService;

    public JobManager() {
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

        monitor();
    }

    public void addJob(Future<T> f, DeferredResult<T> dR) {

        Map<Future<T>, DeferredResult<T>> m = new HashMap<>();
        m.put(f, dR);

        this.jobsUnderExecution.add(m);
    }

    private void monitor() {
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

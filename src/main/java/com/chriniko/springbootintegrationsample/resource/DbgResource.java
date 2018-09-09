package com.chriniko.springbootintegrationsample.resource;

import com.chriniko.springbootintegrationsample.dto.DbgResult;
import com.chriniko.springbootintegrationsample.dto.DrawInfo;
import com.chriniko.springbootintegrationsample.gateway.DbgDrawGateway;
import com.chriniko.springbootintegrationsample.infra.JobManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Future;

@RestController
public class DbgResource {

    private final DbgDrawGateway dbgDrawGateway;
    private final JobManager<DbgResult> dbgResultJobManager;

    @Autowired
    public DbgResource(DbgDrawGateway dbgDrawGateway) {
        this.dbgDrawGateway = dbgDrawGateway;
        dbgResultJobManager = new JobManager<>();
    }

    @RequestMapping(
            value = "/draw",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    DeferredResult<DbgResult> performFooDraw(@RequestBody DrawInfo drawInfo) {

        DeferredResult<DbgResult> dR = new DeferredResult<>(2000L);

        Future<DbgResult> dbgResultFuture = dbgDrawGateway.performSampleDraw(drawInfo);

        dbgResultJobManager.addJob(dbgResultFuture, dR);

        return dR;
    }

}

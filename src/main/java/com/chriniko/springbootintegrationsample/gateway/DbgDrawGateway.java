package com.chriniko.springbootintegrationsample.gateway;

import com.chriniko.springbootintegrationsample.dto.DbgResult;
import com.chriniko.springbootintegrationsample.dto.DrawInfo;

import java.util.concurrent.Future;

public interface DbgDrawGateway {

    Future<DbgResult> performSampleDraw(DrawInfo drawInfo);
}

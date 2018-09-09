package com.chriniko.springbootintegrationsample.it

import com.chriniko.springbootintegrationsample.dto.DbgResult
import com.chriniko.springbootintegrationsample.dto.DrawInfo
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Test
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import kotlin.test.assertEquals

class DbgResourceIT : IntegrationTest() {

    @Test
    fun dbg_resource_works_as_expected() {

        // given
        val drawInfo = DrawInfo()
        drawInfo.drawNumber = 1

        val httpEntity = HttpEntity(drawInfo)

        // when
        val responseEntity = restTemplate.exchange(
                "http://localhost:$apiPort/draw",
                HttpMethod.POST,
                httpEntity,
                DbgResult::class.java
        )

        // then
        Assert.assertNotNull(responseEntity)
        Assert.assertNotNull(responseEntity.body)

        val body: DbgResult = responseEntity.body

        assertEquals(1, body.drawInfo.drawNumber)
        assertEquals(20, body.tickets.size)
        assertTrue(body.groupingByOutcome["WIN"] != null)
        assertTrue(body.groupingByOutcome["LOSE"] != null)

    }


}
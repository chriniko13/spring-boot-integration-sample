package com.chriniko.springbootintegrationsample.it

import com.chriniko.springbootintegrationsample.dto.BikeInfo
import com.chriniko.springbootintegrationsample.dto.RiderInfo
import org.junit.Assert
import org.junit.Test
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import kotlin.test.assertEquals

class BikeResourceIT : IntegrationTest() {

    @Test
    fun bike_resource_works_as_expected_case_1() {

        // given
        val riderInfo = RiderInfo()
        riderInfo.isYouCrazy = true

        val httpEntity = HttpEntity(riderInfo)

        // when
        val responseEntity = restTemplate.exchange(
                "http://localhost:$apiPort/bikes",
                HttpMethod.POST,
                httpEntity,
                BikeInfo::class.java
        )

        // then
        Assert.assertNotNull(responseEntity)
        Assert.assertNotNull(responseEntity.body)

        val body: BikeInfo = responseEntity.body

        assertEquals("Yamaha", body.make)
        assertEquals("R1", body.model)
        assertEquals("2017", body.year)
    }

    @Test
    fun bike_resource_works_as_expected_case_2() {

        // given
        val riderInfo = RiderInfo()
        riderInfo.isYouCrazy = false

        val httpEntity = HttpEntity(riderInfo)

        // when
        val responseEntity = restTemplate.exchange(
                "http://localhost:$apiPort/bikes",
                HttpMethod.POST,
                httpEntity,
                BikeInfo::class.java
        )

        // then
        Assert.assertNotNull(responseEntity)
        Assert.assertNotNull(responseEntity.body)

        val body: BikeInfo = responseEntity.body

        assertEquals("Yamaha", body.make)
        assertEquals("MT-10", body.model)
        assertEquals("2017", body.year)
    }

}
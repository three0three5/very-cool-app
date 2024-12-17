package org.example.baseapp.service.impl

import mu.KLogging
import org.example.baseapp.client.FeatureFlagClient
import org.example.baseapp.client.impl.onNullOrFailure
import org.example.baseapp.service.SomeService
import org.springframework.stereotype.Service

@Service
class SomeServiceImpl(
    private val featureClient: FeatureFlagClient
): SomeService {
    override fun calculateNumber(number: Int): Int {
        val result = onNullOrFailure(false) {
            featureClient.isSquared()
        }
        if (result) {
            logger.info { "Getting squared number" }
            return number * number;
        }
        logger.info { "Getting doubled number" }
        return number * 2;
    }

    companion object: KLogging()
}
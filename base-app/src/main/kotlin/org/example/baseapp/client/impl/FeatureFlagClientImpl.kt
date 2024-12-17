package org.example.baseapp.client.impl

import mu.KLogging
import org.example.baseapp.client.FeatureFlagClient
import org.example.baseapp.client.impl.FeatureFlagClientImpl.Companion.logger
import org.example.baseapp.configuration.FeatureFlagClientProperties
import org.example.baseapp.exception.EmptyResponseException
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

@Component
class FeatureFlagClientImpl(
    private val featureFlagWebClient: WebClient,
    private val properties: FeatureFlagClientProperties
): FeatureFlagClient {
    override fun isSquared(): Boolean {
        return featureFlagWebClient
            .get()
            .uri { uriBuilder ->
                uriBuilder.path(properties.pathForFeature!!)
                    .queryParam("feature-name", properties.featureName)
                    .build()
            }
            .retrieve()
            .bodyToMono<Boolean>()
            .block() ?: throw EmptyResponseException()
    }

    companion object: KLogging()
}

fun <T> onNullOrFailure(defaultResult: T, operation: () -> T?): T =
    try {
        operation.invoke() ?: defaultResult.also {
            logger.warn { "Got null on call; ignored" }
        }
    } catch (e: Exception) {
        logger.warn { "Caught exception ${e.message}; ignored" }
        defaultResult
    }
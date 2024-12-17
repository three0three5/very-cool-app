package org.example.baseapp.configuration

import io.netty.channel.ChannelOption
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.http.client.HttpClient
import java.time.Duration

@Configuration
class WebClientConfiguration {
    @Bean
    fun featureFlagWebClient(
        builder: WebClient.Builder,
        properties: FeatureFlagClientProperties,
        clientProperties: DefaultClientProperties
    ): WebClient {
        return builder
            .baseUrl(properties.hostname!!)
            .clientConnector(ReactorClientHttpConnector(
                HttpClient.create()
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, clientProperties.connectionTimeout)
            ))
            .filter {
                request, next ->
                    next.exchange(request)
                        .retry(clientProperties.retry)
                        .timeout(Duration.ofMillis(clientProperties.retryTimeout))
            }
            .build()
    }
}
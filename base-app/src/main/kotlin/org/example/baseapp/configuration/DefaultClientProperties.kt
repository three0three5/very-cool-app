package org.example.baseapp.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix = "client")
@Component
class DefaultClientProperties {
    var connectionTimeout: Int = 3000
    var retry: Long = 1
    var retryTimeout: Long = 5000L
}
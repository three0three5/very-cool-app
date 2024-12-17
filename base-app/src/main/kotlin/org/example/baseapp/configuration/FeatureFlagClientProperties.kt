package org.example.baseapp.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "feature-flag-client")
class FeatureFlagClientProperties {
    var hostname: String? = null
    var pathForFeature: String? = null
    var featureName: String? = null
}
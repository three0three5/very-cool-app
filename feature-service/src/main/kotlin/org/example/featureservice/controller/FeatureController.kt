package org.example.featureservice.controller

import mu.KLogging
import org.example.featureservice.dto.FeatureDto
import org.example.featureservice.service.FeatureService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/feature"])
class FeatureController(
    private val featureService: FeatureService
) {
    @GetMapping
    fun getFeatureValue(
        @RequestParam(name = "feature-name") featureName: String
    ): Boolean {
        logger.info { "Get feature by name $featureName" }
        return featureService.getFeatureValueByName(featureName)
    }

    @PutMapping
    fun createOrUpdateFeature(@RequestBody feature: FeatureDto): FeatureDto {
        logger.info { "Put feature with body: $feature" }
        return featureService.createOrUpdate(feature)
    }

    @GetMapping("/all")
    fun getAllFeatures(
        @PageableDefault(size = 10, sort = ["featureName"]) pageable: Pageable
    ): Page<FeatureDto> {
        logger.info { "Get all features" }
        return featureService.findAll(pageable)
    }

    companion object: KLogging()
}
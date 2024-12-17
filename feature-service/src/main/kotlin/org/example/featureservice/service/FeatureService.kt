package org.example.featureservice.service

import org.example.featureservice.dto.FeatureDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface FeatureService {
    fun getFeatureValueByName(featureName: String): Boolean
    fun createOrUpdate(feature: FeatureDto): FeatureDto
    fun findAll(pageable: Pageable): Page<FeatureDto>
}
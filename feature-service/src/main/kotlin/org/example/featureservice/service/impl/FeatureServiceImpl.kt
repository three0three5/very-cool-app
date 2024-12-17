package org.example.featureservice.service.impl

import org.example.featureservice.dto.FeatureDto
import org.example.featureservice.entity.toDto
import org.example.featureservice.entity.toEntity
import org.example.featureservice.exception.NotFoundException
import org.example.featureservice.repository.FeatureRepository
import org.example.featureservice.service.FeatureService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class FeatureServiceImpl(
    private val repository: FeatureRepository
): FeatureService {
    override fun getFeatureValueByName(featureName: String): Boolean {
        return repository.findById(featureName)
            .orElseThrow{ NotFoundException("Feature with name $featureName not found") }
            .featureValue
    }

    override fun createOrUpdate(feature: FeatureDto): FeatureDto {
        return repository.save(feature.toEntity()).toDto()
    }

    override fun findAll(pageable: Pageable): Page<FeatureDto> {
        return repository.findAll(pageable)
            .map { it.toDto() }
    }
}
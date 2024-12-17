package org.example.featureservice.repository

import org.example.featureservice.entity.FeatureEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface FeatureRepository: CrudRepository<FeatureEntity, String> {
    fun findAll(pageable: Pageable): Page<FeatureEntity>
}
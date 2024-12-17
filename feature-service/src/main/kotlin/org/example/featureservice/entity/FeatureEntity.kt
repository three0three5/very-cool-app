package org.example.featureservice.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.example.featureservice.dto.FeatureDto

@Entity
@Table(name = "features")
data class FeatureEntity(
    @Id
    @Column(name = "feature_name")
    val featureName: String,

    @Column(name = "feature_value", nullable = false)
    val featureValue: Boolean
)

fun FeatureDto.toEntity(): FeatureEntity = FeatureEntity(
    featureName = this.featureName,
    featureValue = this.featureValue
)

fun FeatureEntity.toDto(): FeatureDto = FeatureDto(
    featureName = this.featureName,
    featureValue = this.featureValue
)
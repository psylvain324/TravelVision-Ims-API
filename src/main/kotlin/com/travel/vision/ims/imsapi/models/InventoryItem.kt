package com.travel.vision.ims.imsapi.models

import lombok.Data
import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Document
data class InventoryItem(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    val title: String = "T",

    val content: String = "C"
)

package com.travel.vision.ims.imsapi.models

import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Document("Supplier")
data class Supplier(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        @Indexed
        val supplierName: String,

        val location: String
)
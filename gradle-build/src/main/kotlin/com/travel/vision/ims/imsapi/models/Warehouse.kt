package com.travel.vision.ims.imsapi.models

import lombok.Data
import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Document
data class Warehouse(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        val warehouseName: String = "W",

        val location: String = "L"
)
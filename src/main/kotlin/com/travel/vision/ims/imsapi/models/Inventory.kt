package com.travel.vision.ims.imsapi.models

import lombok.Data
import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.*

@Document
data class Inventory(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        @Column(name = "itemName")
        val itemName: String = "T",

        @Column(name = "quantity")
        val quantity: String = "Q"
)
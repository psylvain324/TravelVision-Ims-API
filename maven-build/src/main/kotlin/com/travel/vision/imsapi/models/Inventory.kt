package com.travel.vision.imsapi.models

import javax.persistence.*

@Entity
data class Inventory(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        val itemName: String = "T",

        val quantity: String = "Q",

        val warehouseName: String = "W"
)
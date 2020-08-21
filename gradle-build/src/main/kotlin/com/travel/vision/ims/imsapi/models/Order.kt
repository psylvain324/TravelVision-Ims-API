package com.travel.vision.ims.imsapi.models

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.hateoas.RepresentationModel
import java.util.*
import javax.persistence.ForeignKey
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Document("Order")
data class Order (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        val customerId: Long,

        val companyName: Customer,

        val quantity: Collection<InventoryItem>,

        val orderTotal: Double,

        val orderDate: Date

): RepresentationModel<Order>()
package com.travel.vision.ims.imsapi.models

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.hateoas.RepresentationModel
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Document("Customer")
data class Customer (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        val companyName: String = "",

        val quantity: String = ""

): RepresentationModel<Customer>()

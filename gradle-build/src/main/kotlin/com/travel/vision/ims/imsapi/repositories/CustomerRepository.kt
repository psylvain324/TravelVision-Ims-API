package com.travel.vision.ims.imsapi.repositories

import com.travel.vision.ims.imsapi.models.Customer
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: MongoRepository<Customer, Long> {

}
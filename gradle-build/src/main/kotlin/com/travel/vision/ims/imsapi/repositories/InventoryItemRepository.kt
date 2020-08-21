package com.travel.vision.ims.imsapi.repositories

import com.travel.vision.ims.imsapi.models.InventoryItem
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface InventoryItemRepository: MongoRepository<InventoryItem, Long> {

}
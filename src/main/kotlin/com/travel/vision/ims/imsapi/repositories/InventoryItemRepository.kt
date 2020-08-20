package com.travel.vision.ims.imsapi.repositories

import com.travel.vision.ims.imsapi.models.InventoryItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository

@Repository
interface InventoryItemRepository: MongoRepository<InventoryItem, Long>, JpaSpecificationExecutor<InventoryItem> {

}
package com.travel.vision.imsapi.repositories

import com.travel.vision.imsapi.models.InventoryItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface InventoryItemRepository: JpaRepository<InventoryItem, Long>, JpaSpecificationExecutor<InventoryItem> {

}
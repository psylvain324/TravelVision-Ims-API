package com.travel.vision.imsapi.repositories

import com.travel.vision.imsapi.models.Inventory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface InventoryRepository: JpaRepository<Inventory, Long>, JpaSpecificationExecutor<Inventory> {
    fun findAllByWarehouseName(warehouseName: String): Inventory?
}
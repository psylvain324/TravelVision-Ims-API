package com.travel.vision.imsapi.repositories

import com.travel.vision.imsapi.models.Warehouse
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface WarehouseRepository: JpaRepository<Warehouse, Long>, JpaSpecificationExecutor<Warehouse> {
    fun findAllByWarehouseName(warehouseName: String): Warehouse?
}
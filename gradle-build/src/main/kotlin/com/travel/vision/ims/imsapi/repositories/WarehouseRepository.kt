package com.travel.vision.ims.imsapi.repositories

import com.travel.vision.ims.imsapi.models.Warehouse
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface WarehouseRepository: MongoRepository<Warehouse, Long>  {
    //fun findAllByWarehouseName(warehouseName: String): Warehouse?
}
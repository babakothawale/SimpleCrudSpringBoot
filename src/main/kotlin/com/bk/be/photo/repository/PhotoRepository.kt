package com.bk.be.photo.repository

import com.bk.be.photo.model.Photo
import org.springframework.data.repository.CrudRepository

interface PhotoRepository: CrudRepository<Photo, Int>
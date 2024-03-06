package com.bk.be.photo.service

import com.bk.be.photo.model.Photo
import com.bk.be.photo.repository.PhotoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PhotoService(val photoRepository: PhotoRepository) {
    fun getPhotos(): MutableIterable<Photo> {
        return photoRepository.findAll()
    }

    fun getPhoto(id: Int): Photo? {
        return photoRepository.findByIdOrNull(id)
    }

    fun removePhoto(id: Int) {
        return photoRepository.deleteById(id)
    }

    fun save(fileName: String, contentType: String, data: ByteArray): Photo {
        val photo = Photo(fileName = fileName, data = data, contentType = contentType)
        photoRepository.save(photo)
        return photo
    }
}
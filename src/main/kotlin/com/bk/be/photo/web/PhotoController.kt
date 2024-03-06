package com.bk.be.photo.web

import com.bk.be.photo.model.Photo
import com.bk.be.photo.service.PhotoService

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.server.ResponseStatusException

@RestController
class PhotoController(val photoService: PhotoService) {

    @GetMapping("/")
    fun hello(): String {
        return "Hello world"
    }

    @GetMapping("/photo")
    fun getPhotos(): MutableIterable<Photo> {
        return photoService.getPhotos()
    }

    @GetMapping("/photo/{id}")
    fun getPhoto(@PathVariable id: Int): Photo {
        return photoService.getPhoto(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/photo/{id}")
    fun delete(@PathVariable id: Int) {
        photoService.removePhoto(id)
    }

    @PostMapping("/photo/")
    fun create(@RequestPart("data") multipartFile: MultipartFile): Photo {
        return photoService.save(
            fileName = multipartFile.originalFilename!!,
            contentType = multipartFile.contentType!!,
            data = multipartFile.bytes
        )
    }
}
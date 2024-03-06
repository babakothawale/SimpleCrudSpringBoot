package com.bk.be.photo.web

import com.bk.be.photo.service.PhotoService
import org.springframework.http.ContentDisposition
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
class DownloadController(val photoService: PhotoService) {

    @GetMapping("/download/{id}")
    fun download(@PathVariable id: Int): ResponseEntity<ByteArray> {

        val photo = photoService.getPhoto(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

        val data: ByteArray = photo.data
        val headers = HttpHeaders()
        headers.contentType = MediaType.valueOf(photo.contentType)
//        val contentDisposition = ContentDisposition.builder("attachment").build()
        val contentDisposition = ContentDisposition.attachment().filename(photo.fileName).build()
        headers.contentDisposition = contentDisposition

        return ResponseEntity(data, headers, HttpStatus.OK)
    }
}
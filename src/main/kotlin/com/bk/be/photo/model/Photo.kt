package com.bk.be.photo.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.validation.constraints.NotEmpty
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("PHOTOS")
data class Photo(@Id var id:Int = 0, @NotEmpty val fileName: String, @JsonIgnore val data: ByteArray, val contentType: String = "")
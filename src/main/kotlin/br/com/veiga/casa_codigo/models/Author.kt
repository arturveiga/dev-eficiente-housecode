package br.com.veiga.casa_codigo.models

import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Author(
    @Id val id: UUID,
    val name: String,
    val email: String,
    val description: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
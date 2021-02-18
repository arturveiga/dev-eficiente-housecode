package br.com.veiga.casa_codigo.models

import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
data class Author(
    @Id val id: UUID,
    @NotBlank val name: String,
    @Email
    @Size(max=400)
    val email: String,
    val description: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
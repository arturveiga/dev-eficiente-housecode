package br.com.veiga.casa_codigo.controllers

import br.com.veiga.casa_codigo.models.Author
import java.util.UUID
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class AuthorRequest(
    @field:NotBlank val name: String,
    @field:Email val email: String,
    @field:NotBlank @field:Size(max=400)  val description: String
) {
    fun toModel(): Author {
        return Author(
            id = UUID.randomUUID(),
            name = this.name,
            email = this.email,
            description = this.description,
        )
    }
}
package br.com.veiga.casa_codigo.controllers.requests

import br.com.veiga.casa_codigo.models.Category
import java.util.UUID
import javax.validation.constraints.NotBlank

data class CategoryRequest(
    @field:NotBlank
    val name:String
){
    fun toModel(): Category = Category(
        id= UUID.randomUUID(),
        this.name
    )
}
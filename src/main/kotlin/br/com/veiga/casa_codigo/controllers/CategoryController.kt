package br.com.veiga.casa_codigo.controllers

import br.com.veiga.casa_codigo.controllers.requests.CategoryRequest
import br.com.veiga.casa_codigo.models.Category
import br.com.veiga.casa_codigo.repositories.CategoryRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/v1/categories")
// max 7
// 4
class CategoryController(
    //1 CategoryRepository
    private val repository: CategoryRepository
) {
    //1 categoryRequest
    //1 category
    //1 repository.save(categoryRequest.toModel())
    @PostMapping
    fun create(@Valid @RequestBody categoryRequest: CategoryRequest): Category {
        return repository.save(categoryRequest.toModel())
    }
}
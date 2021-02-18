package br.com.veiga.casa_codigo.controllers

import br.com.veiga.casa_codigo.controllers.requests.AuthorRequest
import br.com.veiga.casa_codigo.models.Author
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.persistence.EntityManager
import javax.transaction.Transactional
import javax.validation.Valid

// CDD MAX Points = 7
// ICP = 3

@RestController
@RequestMapping("/v1/authors")
class AuthorController(
    val entityManager: EntityManager
) {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //1
    //1
    //1
    @Transactional
    fun create(@Valid @RequestBody request: AuthorRequest) : Author  {
        val author = request.toModel()
        entityManager.persist(author)
        return author
    }

}
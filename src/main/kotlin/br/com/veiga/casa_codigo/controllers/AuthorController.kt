package br.com.veiga.casa_codigo.controllers

import br.com.veiga.casa_codigo.models.Author
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.persistence.EntityManager
import javax.transaction.Transactional
import javax.validation.Valid


/**
 *
NECESSIDADES
    O email do autor precisa ser único no sistema
    resultado esperado
    Erro de validação no caso de email duplicado
 *
 */

// CDD MAX Points = 7
// ICP = 4

@RestController
@RequestMapping("/v1/authors")
class AuthorController(
    val entityManager: EntityManager,
    //1
    val authorEmailDuplicatedValidator: AuthorEmailDuplicatedValidator
) {

    @InitBinder
    fun init(binder: WebDataBinder){
        binder.addValidators(authorEmailDuplicatedValidator)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //1
    //1
    //1
    @Transactional
    fun create(@Valid @RequestBody request: AuthorRequest) : Author  {
        val author = request.toModel()
        // mais coisas aqui
        entityManager.persist(author)
        return author
    }

}
package br.com.veiga.casa_codigo.controllers

import br.com.veiga.casa_codigo.models.Author
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
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
 * NECESSIDADES
    É necessário cadastrar um novo autor no sistema.
    Todo autor tem um nome, email e uma descrição. Também queremos saber o instante exato que ele foi registrado. - ok

   RESTRIÇÕES
    O instante não pode ser nulo - ok
    O email é obrigatório
    O email tem que ter formato válido
    O nome é obrigatório
    A descrição é obrigatória e não pode passar de 400 caracteres
    resultado esperado
    Um novo autor criado e status 200 retornado
 *
 *
 */

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
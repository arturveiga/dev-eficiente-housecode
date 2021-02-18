package br.com.veiga.casa_codigo.controllers

import br.com.veiga.casa_codigo.controllers.requests.AuthorRequest
import br.com.veiga.casa_codigo.repositories.AuthorRepository
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator

@Component
class AuthorEmailDuplicatedValidator(
    val authorRepository: AuthorRepository
) : Validator {
    override fun supports(clazz: Class<*>): Boolean {
       return AuthorRequest::class.java.isAssignableFrom(clazz)
    }

    override fun validate(request: Any, errors: Errors) {
       if(errors.hasErrors()) return

        request as AuthorRequest

        val authorOptional = authorRepository.findByEmail(request.email)

        authorOptional.ifPresent {
            errors.rejectValue("email","", "Ja existe um autor com este email: ${authorOptional.get().email}")
        }

    }
}
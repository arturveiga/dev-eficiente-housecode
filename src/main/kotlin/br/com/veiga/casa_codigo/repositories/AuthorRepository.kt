package br.com.veiga.casa_codigo.repositories

import br.com.veiga.casa_codigo.models.Author
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional
import java.util.UUID

interface AuthorRepository : JpaRepository<Author,UUID> {
    fun findByEmail(email:String) : Optional<Author>
}

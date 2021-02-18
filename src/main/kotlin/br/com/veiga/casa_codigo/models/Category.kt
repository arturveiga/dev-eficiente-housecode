package br.com.veiga.casa_codigo.models

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name="categories")
data class Category(
    @Id
    val id: UUID,
    @NotBlank
    @Column(unique = true)
    val name:String
)
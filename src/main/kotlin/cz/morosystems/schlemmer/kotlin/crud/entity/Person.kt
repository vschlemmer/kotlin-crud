package cz.morosystems.schlemmer.kotlin.crud.entity

import javax.persistence.*

@Entity
data class Person (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var name: String
)

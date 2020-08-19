package cz.morosystems.schlemmer.kotlin.crud.entity

import javax.persistence.*

@Entity
data class Person (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(nullable = false)
    val name: String
)

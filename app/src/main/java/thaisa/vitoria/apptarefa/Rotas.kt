package thaisa.vitoria.apptarefa

import kotlinx.serialization.Serializable

@Serializable
data object Lista

@Serializable
data object Cadastro

@Serializable
data class Detalhes(val id: Int)
package thaisa.vitoria.apptarefa

data class Tarefa(
    val id: Int,
    val descricao: String,
    val concluida: Boolean = false
)
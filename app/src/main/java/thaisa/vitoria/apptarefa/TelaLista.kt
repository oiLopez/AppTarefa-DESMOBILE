package thaisa.vitoria.apptarefa

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TelaLista(
    tarefas: List<Tarefa>,
    onNovaTarefa: () -> Unit,
    onTarefaClick: (Tarefa) -> Unit,
    onConcluir: (Int) -> Unit,
    onExcluir: (Int) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text("Lista de tarefas")

        Button(
            onClick = onNovaTarefa,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Nova tarefa")
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(tarefas) { tarefa ->

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Checkbox(
                        checked = tarefa.concluida,
                        onCheckedChange = {
                            onConcluir(tarefa.id)
                        }
                    )

                    Button(
                        onClick = {
                            onTarefaClick(tarefa)
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(tarefa.descricao)
                    }

                    Button(
                        onClick = {
                            onExcluir(tarefa.id)
                        }
                    ) {
                        Text("Excluir")
                    }
                }
            }
        }
    }
}
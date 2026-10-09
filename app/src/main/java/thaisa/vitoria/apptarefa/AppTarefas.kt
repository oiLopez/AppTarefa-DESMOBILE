package thaisa.vitoria.apptarefa

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute

@Composable
fun AppTarefas(
    tarefaViewModel: TarefaViewModel = viewModel()
) {



    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Lista
    ) {

        composable<Lista> {

            TelaLista(
                tarefas = tarefaViewModel.tarefas,

                onNovaTarefa = {
                    navController.navigate(Cadastro)
                },

                onTarefaClick = { id ->
                    navController.navigate(
                        Detalhes(id)
                    )
                },

                onConcluida = { concluido, id ->
                    tarefaViewModel.alternarConcluida(
                        concluido,
                        id
                    )
                },

                onRemover = { id ->
                    tarefaViewModel.removerTarefa(id)
                }
            )
        }

        composable<Cadastro> {

            TelaCadastro(

                onSalvar = { descricao ->

                    val novoId =
                        (tarefas.maxOfOrNull { it.id } ?: 0) + 1

                    tarefas = tarefas + Tarefa(
                        id = novoId,
                        descricao = descricao
                    )

                    navController.popBackStack()
                },

                onVoltar = {
                    navController.popBackStack()
                }
            )
        }

        composable<Detalhes> { backStackEntry ->

            val rota =
                backStackEntry.toRoute<Detalhes>()

            val tarefa =
                tarefas.firstOrNull {
                    it.id == rota.id
                }

            TelaDetalhes(
                tarefa = tarefa,

                onVoltar = {
                    navController.popBackStack()
                }
            )
        }
    }
}
package br.com.alura.alugames.principal

import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.servicos.ConsumoApi
import java.util.*

fun main() {

    print("Digite um código de jogo para buscar: ")
    val leitura = Scanner(System.`in`)
    val busca = leitura.nextLine()

    val buscaApi = ConsumoApi()
    val meuJogoInfo = buscaApi.buscaJogo(busca)

//    try {
//        val meuJogoInfo = gson.fromJson(json, br.com.alura.alugames.modelo.InfoJogo::class.java)
//        val meuJogo = br.com.alura.alugames.modelo.Jogo(titulo = meuJogoInfo.info.title, capa = meuJogoInfo.info.thumb)
//        println(meuJogo)
//    } catch (e: Exception) {
//        print("br.com.alura.alugames.modelo.Jogo inegistente tente outro ID.")
//    }

    var meuJogo: Jogo? = null
    val resultado = runCatching {

        meuJogo = Jogo(titulo = meuJogoInfo?.info?.title ?: "", capa = meuJogoInfo?.info?.thumb ?: "")
    }

    resultado.onFailure {
        print("br.com.alura.alugames.modelo.Jogo inegistente tente outro ID.")
    }

    resultado.onSuccess {
        print("Deseja inserir uma descrição personalizada? (S/N): ")
        val opcao = leitura.nextLine()

        if (opcao.equals("s", true)) {
            print("Insira a descricão personalizada para o jogo: ")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descrcao = descricaoPersonalizada
        } else {
            meuJogo?.descrcao = meuJogo?.titulo
        }

        println(meuJogo)
    }

    resultado.onSuccess {
        print("Busca finalizada com sucesso")
    }
}
package br.com.alura.alugames.modelo

data class Jogo(
    val titulo: String,
    val capa: String
) {
    var descrcao: String? = null

    override fun toString(): String {
        return "Meu br.com.alura.alugames.modelo.Jogo\n " +
                "titulo='$titulo \n'" +
                "capa='$capa \n'" +
                "descrcao='$descrcao'"
    }
}
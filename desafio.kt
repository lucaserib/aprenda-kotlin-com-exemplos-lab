enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(
    val nome: String,
    val idade: Int,
    var nivel: Nivel? = null
)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    var inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("O Usuário ${usuario.nome} foi matriculado na formação $nome com nível ${usuario.nivel}.")
    }
}

fun calcularNivel(duracaoTotal: Int): Nivel {
    return when {
        duracaoTotal <= 100 -> Nivel.BASICO
        duracaoTotal <= 160 -> Nivel.INTERMEDIARIO
        else -> Nivel.AVANCADO
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Programing Basics", 100)
    val conteudo2 = ConteudoEducacional("Kotlin Introduction", 160)
    val conteudo3 = ConteudoEducacional("Kotlin Developement", 220)
    
    val formacao = Formacao("Kotlin Development", listOf(conteudo1, conteudo2, conteudo3))
    
    val usuario1 = Usuario("Lucas", 22)
    val usuario2 = Usuario("Luana", 24)
    val usuario3 = Usuario("Pedro", 23)

    val duracaoTotal = formacao.conteudos.sumBy { it.duracao }
    usuario1.nivel = calcularNivel(duracaoTotal)
    usuario2.nivel = calcularNivel(duracaoTotal)
    usuario3.nivel = calcularNivel(duracaoTotal)
    
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario3)
}
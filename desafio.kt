enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(
    val nome: String,
    val idade: Int,
    var nivel: Nivel? = null
)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

class Formacao(
    val nome: String,
    val conteudos: List<ConteudoEducacional>,
    val tipo: String // Adicionamos um tipo para a formação
) {
    var inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        // Define o nível com base no tipo da formação
        usuario.nivel = when (tipo) {
            "Programing Basics" -> Nivel.BASICO
            "Kotlin Introduction" -> Nivel.INTERMEDIARIO
            "Kotlin Development" -> Nivel.AVANCADO
            else -> null
        }
        println("O Usuário ${usuario.nome}, de ${usuario.idade} anos foi matriculado na formação $nome com tipo $tipo e nível ${usuario.nivel}.")
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Programing Basics", 100)
    val conteudo2 = ConteudoEducacional("Kotlin Introduction", 160)
    val conteudo3 = ConteudoEducacional("Kotlin Development", 220)
    
    val formacao1 = Formacao("Formação 1", listOf(conteudo1, conteudo2, conteudo3), "Programing Basics")
    val formacao2 = Formacao("Formação 2", listOf(conteudo1, conteudo2, conteudo3), "Kotlin Introduction")
    val formacao3 = Formacao("Formação 3", listOf(conteudo1, conteudo2, conteudo3), "Kotlin Development")
    
    val usuario1 = Usuario("Lucas", 22)
    val usuario2 = Usuario("Luana", 24)
    val usuario3 = Usuario("Pedro", 23)

    // Matricular os alunos em diferentes formações
    formacao1.matricular(usuario1)
    formacao2.matricular(usuario2)
    formacao3.matricular(usuario3)
}
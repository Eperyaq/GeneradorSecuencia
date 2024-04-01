import kotlin.contracts.contract

class GeneradorSecuencia(private val consola: IEntradaSalida) {

    private lateinit var sec: Sequence<String>
    private fun lineSequence(limit: Int = Int.MAX_VALUE) = generateSequence { readln() }.constrainOnce().take(limit)

    /**
     * Muestra una frase con un numero máximo de palabras y al acabar de escribir una palabra, se muestra
     * @param numero Numero maximo de palabras
     */
    fun fraseIncremental(numero: Int?){
        if (numero != null) {
            sec = lineSequence(numero)
            sec.forEach { consola.mostrarInfo(it) }
        }
    }

    /**
     *Muestra una frase con un numero maximo de palabras y al acabar de escribir la frase la muestra completa
     * @param numero El numero de palabras que va a tener la frase
     */
    fun fraseFinal(numero: Int?){
        if (numero != null) {
            sec = lineSequence(numero)
        }
        mostrarSec()
    }

    /**
     * Forma una lista con las palabras escritas y las une en un String juntos
     */
    fun getSec() = sec.toList().joinToString(" ")

    /**
     * Muestra la frase completa
     */
    fun mostrarSec(){
        consola.mostrarInfo(getSec())
    }
}
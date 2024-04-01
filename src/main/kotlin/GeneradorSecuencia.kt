class GeneradorSecuencia(consola: Consola) {

    private lateinit var sec: Sequence<String>
    private fun lineSequence(limit: Int = Int.MAX_VALUE) = generateSequence { readln() }.constrainOnce().take(limit)


    fun fraseIncremental(){

    }

}
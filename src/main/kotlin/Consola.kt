class Consola:IEntradaSalida {
    override fun preguntarEntero(): Int {
        var num = readLine()?.toInt()

        do {
            mostrarInfo("Introduzca el numero de caracteres que va a tener la frase: ")


            if (num != null) {
                 break
            } else {
                mostrarInfo("Valor erroneo, pruebe de nuevo.")
                num = null
            }
        } while (num != null)

        return num
    }

    override fun preguntarString() {
        TODO("Not yet implemented")
    }


    /**
     * Muestra la informacion que se le pasa por parámetros
     * @param text Texto a mostrar
     */
    override fun mostrarInfo(text: String) {
        println(text)
    }
}
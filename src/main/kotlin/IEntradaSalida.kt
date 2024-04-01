interface IEntradaSalida {

    /**
     * Pregunta por un numero entero y lo retorna
     */
    fun preguntarEntero():Int?

    /**
     * Pregunta por un string y lo retorna
     */
    fun preguntarString():String?

    /**
     * Muestra la informacion pasada por parametros
     * @param text Texto a mostrar
     */
    fun mostrarInfo(text:String)


}
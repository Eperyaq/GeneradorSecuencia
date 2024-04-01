class Consola:IEntradaSalida {

    /**
     * Pregunta por un numero Entero y comprueba si es entero, si no lo es sigue en un bucle hasta que lo sea
     */
    override fun preguntarEntero(): Int? {
        var numero: Int? = 0
        mostrarInfo("Introduzca el numero de caracteres que va a tener la frase: ")

        do {

            numero = readln().toIntOrNull()

            if ( numero != null && numero != 0 ) {
                break
            }else {
                mostrarInfo("ERROR, valor no válido, pruebe de nuevo")
            }

        }while ( numero == 0 || numero ==null )

        return numero
    }

    /**
     * Preguntas por una cadena de palabras y compruebas que sea asi
     */
    override fun preguntarString():String? {

        var string:String? = ""
        mostrarInfo("Introduzca la cadena: ")

        do {
            string = readlnOrNull()

            if ( string != null && string != "" ) {
                break
            }else {
                mostrarInfo("ERROR, valor no válido, pruebe de nuevo")
            }

        }while ( string != null || string != "" )

        return string
    }

    /**
     * Menu que da a escoger entre las opciones que puedes hacer
     * @param generadorSecuencia Funcion en la que se encuentran los metodos a usar
     */
    fun menu(generadorSecuencia: GeneradorSecuencia) {
        do {
            mostrarInfo("Que deseas hacer \n 1.- Formar una frase y mostrarla una por una \n 2.- Formar una frase y mostrarla entera \n 3.- Salir ")
            val opcion = opciones(3)

            when (opcion) {
                1 -> generadorSecuencia.fraseIncremental(preguntarEntero())
                2 -> generadorSecuencia.fraseFinal(preguntarEntero())
                3 -> mostrarInfo("Adios...")
            }
        }while (opcion != 3)

    }


    /**
     * Muestra la informacion que se le pasa por parámetros
     * @param text Texto a mostrar
     */
    override fun mostrarInfo(text: String) {
        println(text)
    }


    /**
     * Solicita al usuario introducir una opcion entre un rango especifico
     *
     * @param maxop Numero maximo de opciones que va a tener disponibles
     * @throws IllegalArgumentException Si el numero introducido por consola es mayor que [maxop] o igual que 0
     * @return opcion La opcion escogida
     */
    fun opciones(maxop:Int):Int{
        mostrarInfo("Escoge tu opcion: ")
        var opcion = preguntarnum()
        var pinguinito = true

        while (pinguinito) {
            try {

                if (opcion > maxop || opcion ==0) {
                    throw IllegalArgumentException("Escoge un valor correcto") // si indican un numero mayor al pasado por parametros da error
                } else {
                    pinguinito = false
                }
            } catch (e: IllegalArgumentException) {
                mostrarInfo("ERROR, escoge un valor correcto")
                opcion = preguntarnum()
            }
        }
        return opcion
    }


    /**
     * Solicita al usuario introducir un numero a traves de la consola
     * Hasta que no introduce un numero correcto no va a parar de preguntar por ese numero
     * @return El numero introducido por el usuario
     */
    private fun preguntarnum(): Int {
        var penguin = true
        var numero= 0

        while ( penguin ) {
            try {
                numero = readln().toInt()
                penguin = false
            } catch ( e: NumberFormatException ) {
                mostrarInfo("Inserte un numero válido")
            }
        }
        return numero
    }
}
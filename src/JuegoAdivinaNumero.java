public class JuegoAdivinaNumero extends JuegoConVidas{
    private int _numeroAdivinar;

    public JuegoAdivinaNumero(int numeroVidasIniciales, int numeroAdivinar) {
        super(numeroVidasIniciales);

        if (this.validaNumero(numeroAdivinar)) {
            this._numeroAdivinar = numeroAdivinar;
        }
    }

    public boolean validaNumero (int numero){
        if (numero >= 0 && numero <= 10) {
            return true;
        }
        System.out.println("El número a adivinar debe estar entre 0 y 10.");
        return false;
    }


    public boolean juega(String intento) {

        // Comprobamos el formato del input
        int intentoInt;
        try {
            intentoInt = Integer.parseInt(intento);
        } catch (NumberFormatException e) {
            System.out.println("El intento debe ser un número válido entre 0 y 10.");
            return true;
        }

        if (!validaNumero(intentoInt)){
            return true;
        }


        // Comprobamos si ha ganado
        if (intentoInt == _numeroAdivinar) {
            System.out.println("Acertaste!!");
            actualizaRecord();
            return false;
        }

        // Orientamos al jugador
        String comparacion = intentoInt > _numeroAdivinar ? "mayor" : "menor";
        System.out.println("El número que dijiste es " + comparacion + " que el número a adivinar.");

        return super.quitaVida();
    }


}

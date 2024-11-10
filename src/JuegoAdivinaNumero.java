import java.util.Random;

public class JuegoAdivinaNumero extends JuegoConVidas implements Jugable{
    private int _numeroAdivinar;
    protected Random _random = new Random(System.currentTimeMillis());

    public JuegoAdivinaNumero(int numeroVidasIniciales) {
        super(numeroVidasIniciales);
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

    public void muestraNombre(){
        System.out.println("Adivina un número");
    }

    public void muestraInfo() {
        String info = String.format(
                "En este juego debes adivinar el número oculto proponiendo números del 1 al 10. Dispondrás de %d intentos. Cada vez que falles, se te indicará si el número buscado es mayor o menor que el que propusiste.",
                getVidasIniciales()
        );
        System.out.println(info);
    }

    // Número aleatorio
    protected int numAleatorio(){
        return 1  + this._random.nextInt(10);
    }

    @Override
    public void reiniciaPartida() {
        this._numeroAdivinar = numAleatorio();
        super.reiniciaPartida();
    }

}

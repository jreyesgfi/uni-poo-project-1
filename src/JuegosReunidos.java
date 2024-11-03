public class JuegosReunidos {
    private Jugable[] juegosReunidos = new Jugable[3];
    private int vidas = 5;

    /*public enum IndiceJuego {
        ADIVINA_NUMERO,
        ADIVINA_NUMERO_PAR,
        ADIVINA_NUMERO_IMPAR
    }
        public Jugable recuperarJuego(IndiceJuego indice){
        return juegosReunidos[indice.ordinal()];
    }*/

    public JuegosReunidos() {
        // Parámetros del juego
        int numeroAdivinar = 3;
        int numeroAdivinarPar = 8;
        int numeroAdivinarImpar = 5;

        // Creamos los juegos
        Jugable juegoAdivinaNumero = new JuegoAdivinaNumero(this.vidas, numeroAdivinar);
        Jugable juegoAdivinaNumeroPar = new JuegoAdivinaNumeroPar(this.vidas, numeroAdivinarPar);
        Jugable juegoAdivinaNumeroImpar = new JuegoAdivinaNumeroImpar(this.vidas, numeroAdivinarImpar);

        // Guardamos los juegos
        this.juegosReunidos[0] =  juegoAdivinaNumero;
        this.juegosReunidos[1] = juegoAdivinaNumeroPar;
        this.juegosReunidos[2] = juegoAdivinaNumeroImpar;
    }


    public Jugable recuperarJuego(int indice){
        return juegosReunidos[indice-1];
    }
}

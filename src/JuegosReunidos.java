public class JuegosReunidos {
    Jugable[] juegosReunidos = new Jugable[3];

    public enum IndiceJuego {
        ADIVINA_NUMERO,
        ADIVINA_NUMERO_PAR,
        ADIVINA_NUMERO_IMPAR
    }

    public JuegosReunidos() {
        // Parámetros del juego
        int vidas = 0;
        int numeroAdivinar = 3;
        int numeroAdivinarPar = 8;
        int numeroAdivinarImpar = 5;

        // Creamos los juegos
        Jugable juegoAdivinaNumero = new JuegoAdivinaNumero(vidas, numeroAdivinar);
        Jugable juegoAdivinaNumeroPar = new JuegoAdivinaNumeroPar(vidas, numeroAdivinarPar);
        Jugable juegoAdivinaNumeroImpar = new JuegoAdivinaNumeroImpar(vidas, numeroAdivinarImpar);

        // Guardamos los juegos
        this.juegosReunidos[0] =  juegoAdivinaNumero;
        this.juegosReunidos[1] = juegoAdivinaNumeroPar;
        this.juegosReunidos[2] = juegoAdivinaNumeroImpar;
    }

    public Jugable recuperarJuego(IndiceJuego indice){
        return juegosReunidos[indice.ordinal()];
    }
}

import java.util.ArrayList;

public class JuegosReunidos {

    private ArrayList<Jugable> juegosReunidos;
    //private Jugable[] juegosReunidos = new Jugable[3];
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

        // Creamos los juegos
        Jugable juegoAdivinaNumero = new JuegoAdivinaNumero(this.vidas);
        Jugable juegoAdivinaNumeroPar = new JuegoAdivinaNumeroPar(this.vidas);
        Jugable juegoAdivinaNumeroImpar = new JuegoAdivinaNumeroImpar(this.vidas);

        // Guardamos los juegos
        juegosReunidos = new ArrayList<>();
        juegosReunidos.add(juegoAdivinaNumero);
        juegosReunidos.add(juegoAdivinaNumeroPar);
        juegosReunidos.add(juegoAdivinaNumeroImpar);
    }


    public Jugable recuperarJuego(int indice_base_1){
        return juegosReunidos.get(indice_base_1 - 1);
    }

    protected void agregar(Jugable juego){
        juegosReunidos.add(juego);
    }
}

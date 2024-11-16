package App;

import java.io.Serializable;
import java.util.ArrayList;

public class JuegosReunidos implements Serializable {

    private ArrayList<Jugable> juegosReunidos;
    protected int vidas = 5;


    /**
     * Constructor de App.JuegosReunidos que instancia los juegos de adivinar números con 5 vidas.
     * Almacena dichos juegos en juegosReunidos para su posterior uso.
     */
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


    /**
     * Devuelve el juego seleccionado de la lista de juegosReunidos
     * @param indiceEnBase1 Índice del juego seleccionado comenzando por 1
     * @return juego seleccionado de la lista de juegosReunidos
     */
    public Jugable recuperarJuego(int indiceEnBase1){
        return juegosReunidos.get(indiceEnBase1 - 1);
    }

    protected void agregar(Jugable juego){
        juegosReunidos.add(juego);
    }
}

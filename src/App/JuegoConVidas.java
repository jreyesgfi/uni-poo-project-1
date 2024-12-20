package App;

import java.io.Serializable;

/**
 * Clase para gestionar las vidas y el registro de récords en el juego "App.JuegoConVidas".
 * Esta clase proporciona métodos para manejar el estado del juego, incluyendo el conteo de vidas y el seguimiento del récord más alto.
 */
abstract class JuegoConVidas implements Serializable {

    private int vidas;
    private int vidas_iniciales;
    private int record = 0;

    /**
     * Construye un nuevo juego con un número especificado de vidas iniciales.
     * @param numeroVidasIniciales el número de vidas con las que el jugador comienza.
     */
    public JuegoConVidas(int numeroVidasIniciales) {
        this.vidas_iniciales = numeroVidasIniciales;
        this.vidas = numeroVidasIniciales;
    }


    /**
     * Muestra el número de vidas restantes para el jugador.
     */
    private void muestraVidasRestantes() {
        System.out.println("Vidas restantes: " + this.vidas);
    }

    /**
     * Devuelve el número de vidas iniciales del jugador.
     */
    public int getVidasIniciales(){
        return this.vidas_iniciales;
    }

    /**
     * Decrementa el número de vidas en uno y comprueba si el juego ha terminado.
     * @return true si aún quedan vidas, false de lo contrario.
     */
    public boolean quitaVida() {
        this.vidas--;
        if (this.vidas > 0) {
            muestraVidasRestantes();
            return true;
        }
        System.out.println("Juego Terminado");
        return false;
    }

    /**
     * Reinicia el juego al número inicial de vidas.
     */
    public void reiniciaPartida() {
        this.vidas = this.vidas_iniciales;
    }

    /**
     * Actualiza el récord de vidas si las vidas restantes actuales superan el récord.
     * Muestra un mensaje cuando se alcanza o se supera el récord.
     */
    public void actualizaRecord() {
        if (this.vidas == record) {
            System.out.println("Record de vidas alcanzado con " + this.vidas + " vidas");
        } else if (this.vidas > record) {
            record = this.vidas;
            System.out.println("Record de vidas batido, el nuevo record es: " + this.vidas);
        }
    }

    /**
     * Devuelve el record de vidas histórico.
     * @return record de vidas histórico
     */
    public int getRecord() {
        return this.record;
    }

    /**
     * Devuelve el número de vidas restantes en la partida actual.
     * @return número de vidas restantes en la partida actual
     */
    public int getVidasRestantes() {
        return this.vidas;
    }

    //public abstract boolean juega(String intento);
}

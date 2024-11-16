package App;

public interface Jugable {
    boolean juega(String intento);

    void reiniciaPartida();

    /**
     * Muestra el nombre del juego.
     */
    void muestraNombre();

    /**
     * Muestra la información de cómo se juega al juego.
     */
    void muestraInfo();

    /**
     * Valida el formato del intento proporcionado.
     * @param intento
     */
    boolean validaFormato(String intento);
}

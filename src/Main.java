public class Main {
    public static void main(String[] args) {
        JuegoConVidas juego1 = new JuegoConVidas(5);
        juego1.muestraVidasIniciales();
        juego1.quitaVida();

        JuegoConVidas juego2 = new JuegoConVidas(5);
        juego2.muestraVidasIniciales();
        juego2.actualizaRecord();
        juego2.quitaVida();

        juego1.reiniciaPartida();
        juego1.muestraVidasRestantes();
        juego1.actualizaRecord();

    }
}
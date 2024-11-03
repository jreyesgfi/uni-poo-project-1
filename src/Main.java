import Entrada.MyInput;


public class Main {
    public static void main(String[] args) {


        // Jugamos
        jugar(juegoAdivinaNumero);
        jugar(juegoAdivinaNumeroPar);
        jugar(juegoAdivinaNumeroImpar);

    }
    static void jugar(Jugable juego){
        // Mostramos información inicial
        juego.muestraNombre();
        juego.muestraInfo();

        // Reiniciamos las variables del juego
        juego.reiniciaPartida();
        boolean jugando = true;

        // Jugamos
        while (jugando){
            String intento = MyInput.readString();
            jugando = juego.juega(intento);
        }
    }
}
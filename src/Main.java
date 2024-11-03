import Entrada.MyInput;


public class Main {
    public static void main(String[] args) {
        // Parámetros del juego
        int vidas = 0;
        int numeroAdivinar = 3;
        int numeroAdivinarPar = 8;
        int numeroAdivinarImpar = 5;

        // Creamos los juegos
        Jugable juegoAdivinaNumero = new JuegoAdivinaNumero(vidas, numeroAdivinar);
        Jugable juegoAdivinaNumeroPar = new JuegoAdivinaNumeroPar(vidas, numeroAdivinarPar);
        Jugable juegoAdivinaNumeroImpar = new JuegoAdivinaNumeroImpar(vidas, numeroAdivinarImpar);

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
import Entrada.MyInput;


public class Main {
    public static void main(String[] args) {
        // Parámetros del juego
        int vidas = 0;
        int numeroAdivinar = 3;
        int numeroAdivinarPar = 8;
        int numeroAdivinarImpar = 5;

        // Creamos los juegos
        JuegoAdivinaNumero juegoAdivinaNumero = new JuegoAdivinaNumero(vidas, numeroAdivinar);
        JuegoAdivinaNumeroPar juegoAdivinaNumeroPar = new JuegoAdivinaNumeroPar(vidas, numeroAdivinarPar);
        JuegoAdivinaNumeroImpar juegoAdivinaNumeroImpar = new JuegoAdivinaNumeroImpar(vidas, numeroAdivinarImpar);

        // Jugamos
        jugar(juegoAdivinaNumero);
        jugar(juegoAdivinaNumeroPar);
        jugar(juegoAdivinaNumeroImpar);

    }
    static void jugar(JuegoConVidas juego){
        juego.reiniciaPartida();
        boolean jugando = true;
        while (jugando){
            String intento = MyInput.readString();
            jugando = juego.juega(intento);
        }
    }
}
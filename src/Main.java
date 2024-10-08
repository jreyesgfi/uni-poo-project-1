import Entrada.MyInput;


public class Main {
    public static void main(String[] args) {
        JuegoAdivinaNumero juego1 = new JuegoAdivinaNumero(10,5);
        juego1.reiniciaPartida();
        boolean jugando = true;
        while (jugando){
            String intento = MyInput.readString();
            jugando = juego1.juega(intento);
        }
    }
}
import Entrada.MyInput;

public class Menu {
    JuegosReunidos juegosReunidos;

    public Menu(JuegosReunidos juegosReunidosInstancia) {
        this.juegosReunidos = juegosReunidosInstancia;
    }

    void jugar(Jugable juego){
        // Mostramos información inicial
        juego.muestraNombre();
        juego.muestraInfo();

        // Reiniciamos las variables del juego
        juego.reiniciaPartida();
        boolean jugando = true;

        // Jugamos
        String intento = "";
        while (jugando) {
            boolean intentoValido = false;
            while (!intentoValido) {
                System.out.print("\nIntroduzca su intento: ");
                intento = MyInput.readString();
                intentoValido = juego.validaFormato(intento);
                if (!intentoValido) {
                    System.out.print("\nIntento incorrecto.");
                }
            }
            jugando = juego.juega(intento);
        }
    }

    protected void mostrarOpciones(){
        String texto =
                "¿A que quieres jugar?\n" +
                "Introduce un 1 si quieres jugar a Adivinar un número.\n" +
                "Introduce un 2 si quieres jugar a Adivinar un número par.\n" +
                "Introduce un 3 si quieres jugar a Adivinar un número impar.";
        System.out.println(texto);
    }

    protected boolean chequeoOpcion(int opcion){
        return opcion >=1 && opcion <= 3;
    }

    private int eligeOpcion(){
        boolean elegido = false;
        int opcion;
        do {
            mostrarOpciones();
            opcion = MyInput.readInt();
            elegido = chequeoOpcion(opcion);

            // Selección incorrecta
            if (elegido == false) {
                System.out.println("Selección incorrecta. Escoja un valor de las opciones.");
            }

        } while (!elegido);
        return opcion;
    }

    private boolean seguirJugando(){
        System.out.println("¿Desea seguir jugando? (En caso afirmativo introducir 's')");
        String input = MyInput.readString();
        return input.equals("s");
    }

    public void ejecuta(){
        boolean jugando = true;
        while (jugando){
            int opcion = eligeOpcion();
            Jugable juego = this.juegosReunidos.recuperarJuego(opcion);
            jugar(juego);
            jugando = seguirJugando();
        }
    }
}

import Entrada.MyInput;


public class Main {
    public static void main(String[] args) {
        JuegosReunidosExtendido juegosReunidosExtendidos = new JuegosReunidosExtendido();
        MenuExtendido menu = new MenuExtendido(juegosReunidosExtendidos);
        menu.ejecuta();
    }

}
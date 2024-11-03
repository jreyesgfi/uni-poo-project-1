import Entrada.MyInput;


public class Main {
    public static void main(String[] args) {
        JuegosReunidos juegosReunidos = new JuegosReunidos();
        Menu menu = new Menu(juegosReunidos);
        menu.ejecuta();
    }

}
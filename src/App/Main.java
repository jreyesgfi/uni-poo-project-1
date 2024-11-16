package App;

import Entrada.MyInput;


public class Main {
    public static void main(String[] args) {
        // Cargar los juegos
        JuegosReunidos jr=MyInput.deserialize("juegos.dat");
        if (jr==null)
            jr= new JuegosReunidosExtendidos();

        // Creamos un menú con dichos juegos
        Menu mp=new MenuExtendido(jr);

        // Ejecutamos el menú
        mp.ejecuta();

        // Guardamos el estado
        MyInput.serialize(jr,"juegos.dat");
    }
}
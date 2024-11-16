package App;

import Entrada.MyInput;

import java.util.ArrayList;

public class JuegosReunidosExtendidos extends JuegosReunidos{

    /**
     * Constructor de App.JuegosReunidosExtendidos que añade el juego del App.JuegoAhorcadoIngles
     * a la lista de juegosReunidos de la que hereda.
     */
    public JuegosReunidosExtendidos(){
        super();
        ArrayList<String> diccionario = MyInput.leeFichero("diccionario.txt");
        Jugable ahorcadoIngles = new JuegoAhorcadoIngles(this.vidas, diccionario);
        agregar(ahorcadoIngles);
    }

}

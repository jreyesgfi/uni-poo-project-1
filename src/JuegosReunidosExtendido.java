import Entrada.MyInput;

import java.util.ArrayList;

public class JuegosReunidosExtendido extends JuegosReunidos{
    public JuegosReunidosExtendido(){
        super();
        ArrayList<String> diccionario = MyInput.leeFichero("diccionario.txt");
        Jugable ahorcadoIngles = new JuegoAhorcadoIngles(this.vidas, diccionario);
        agregar(ahorcadoIngles);
    }

}

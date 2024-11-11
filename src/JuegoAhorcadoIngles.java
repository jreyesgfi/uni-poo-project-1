import java.util.ArrayList;
import java.util.Random;

public class JuegoAhorcadoIngles extends JuegoConVidas implements Jugable{
    ArrayList<Character> palabra_adivinar;
    ArrayList<Character> guiones;
    ArrayList<String> diccionario;
    private Random _random = new Random();

    public JuegoAhorcadoIngles(int numeroVidasIniciales, ArrayList<String> diccionarioInicial) {
        super(numeroVidasIniciales);
        this.diccionario = diccionarioInicial;
    }

    public void muestraNombre(){
        System.out.println("Ahorcado en inglés");
    }

    public void muestraInfo() {
        String info = String.format(
                "En este juego debes adivinar la palabra oculta. "
        );
        System.out.println(info);
    }

    private boolean existeCaracter(Character c_propuesto){
        int contador = 0;
        int longitud_palabra = palabra_adivinar.size();

        for (int i=0; i<longitud_palabra; i++){
            Character c_palabra = palabra_adivinar.get(i);
            if (c_palabra.equals(c_propuesto)){
                guiones.set(i,c_palabra);
                contador++;
            }
        }
        return contador != 0;
    }


    private void mostrarArray(ArrayList<Character> array){
        // Hay métodos más eficientes que no comprendo totalmente, como
        // String output = String.join("", palabra.stream().map(String::valueOf).toArray(String[]::new));
        array.forEach(c -> System.out.print(c + " "));
        String word = "";
        for (Character c : array){
            word += c.toString();
        }
        System.out.println(word);
    }

    private void resetearPalabra(){
        // Vaciamos los array de caracteres
        this.palabra_adivinar = new ArrayList<>();
        this.guiones = new ArrayList<>();

        // Comprobamos el diccionario
        if (this.diccionario == null || diccionario.isEmpty()) {
            throw new IllegalArgumentException("Diccionario vacío");
        }

        // Seleccionamos al azar
        int indice = _random.nextInt(this.diccionario.size());
        String nuevaPalabra = this.diccionario.get(indice);

        // Rellenamos los array de caracteres
        int longitudPalabra = nuevaPalabra.length();
        for (int i=0; i<longitudPalabra; i++){
           this.palabra_adivinar.add(nuevaPalabra.charAt(i));
           this.guiones.add('_');
        }

    }

    @Override
    public void reiniciaPartida(){
        muestraNombre();
        muestraInfo();

        resetearPalabra();

        mostrarArray(this.guiones);
    }

    private boolean juego_ganado(){
        for (Character c : this.guiones){
            if (c.equals("_")){
                return false;
            }
        }
        return true;
    }

    public boolean juega(String intento){
        Character letra = intento.charAt(0);
        boolean acierto = existeCaracter(letra);

        // Si hemos acertado
        if (acierto){
            mostrarArray(this.guiones);
            if (juego_ganado()) {
                System.out.println("Acertaste!!");
                actualizaRecord();
                return false;
            }
            return true;
        }

        // Si no hemos acertado
        return quitaVida();
    }
}

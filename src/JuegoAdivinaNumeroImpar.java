public class JuegoAdivinaNumeroImpar extends JuegoAdivinaNumero{

    JuegoAdivinaNumeroImpar(int numeroVidasIniciales, int numeroAdivinar) {
        super(numeroVidasIniciales, numeroAdivinar);
    }

    @Override
    public boolean validaNumero (int numero){
        // Comprobamos rango
        if (numero < 0 || numero > 10) {
            System.out.println("El número a adivinar debe estar entre 0 y 10.");
            return false;
        }

        // Comprobamos paridad
        if (numero % 2 == 0) {
            System.out.println("El número debe ser impar.");
            return false;
        }

        return true;
    }


    public void muestraNombre(){
        System.out.println("Adivina un número impar");
    }

    public void muestraInfo() {
        String info = String.format(
                "En este juego debes adivinar el número oculto proponiendo números impares del 1 al 9. Dispondrás de %d intentos. Cada vez que falles, se te indicará si el número buscado es mayor o menor que el que propusiste.",
                getVidasIniciales()
        );
        System.out.println(info);
    }

    @Override
    protected int numAleatorio(){
        return 1  + 2*this._random.nextInt(5);
    }
}

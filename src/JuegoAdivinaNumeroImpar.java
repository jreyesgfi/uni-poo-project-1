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
}

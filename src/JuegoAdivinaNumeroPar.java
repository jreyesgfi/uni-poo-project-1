public class JuegoAdivinaNumeroPar extends JuegoAdivinaNumero{

    JuegoAdivinaNumeroPar(int numeroVidasIniciales, int numeroAdivinar) {
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
         if (numero % 2 == 1) {
             System.out.println("El número debe ser par.");
             return false;
         }

         return true;
     }
}

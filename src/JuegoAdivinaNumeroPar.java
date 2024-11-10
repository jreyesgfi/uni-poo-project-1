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

     @Override
     public void muestraNombre(){
         System.out.println("Adivina un número par");
     }

     @Override
    public void muestraInfo() {
        String info = String.format(
                "En este juego debes adivinar el número oculto proponiendo números pares del 2 al 10. Dispondrás de %d intentos. Cada vez que falles, se te indicará si el número buscado es mayor o menor que el que propusiste.",
                getVidasIniciales()
        );
        System.out.println(info);
    }

    @Override
    protected int numAleatorio(){
        return 2 + 2 * super._random.nextInt(5);
    }
}

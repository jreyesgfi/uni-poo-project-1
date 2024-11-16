package App;

import java.util.Random;

public class NumeroDeterminado extends Random {
    private int _constantValue;

    /**
     * Clase para enmascarar la clase Random, sobreescribiendo
     * sus métodos por equivalentes determinados para facilitar
     * la ejecución de TEST.
     * Almacena un valor constante el cual es devuelto de manera consistente
     * por todos los métodos sobreescritos.
     * @param value
     */
    public NumeroDeterminado(int value) {
        super();
        this._constantValue = value;
    }

    /**
     * Método que devuelve el valor constante almacenado.
     * @param notUsedValue Valor no utilizado pero necesario como argumento para enmascarar
     *                     las llamadas a su análogo heredado.
     * @return
     */
    @Override
    public int nextInt(int notUsedValue){
        return this._constantValue;
    }
}

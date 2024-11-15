import java.util.Random;

public class NumeroDeterminado extends Random {
    private int _constantValue;
    public NumeroDeterminado(int value) {
        super();
        this._constantValue = value;
    }

    @Override
    public int nextInt(int notUsedValue){
        return this._constantValue;
    }
}

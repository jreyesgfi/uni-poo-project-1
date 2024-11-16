package App;

public class MenuExtendido extends Menu{
    public MenuExtendido(JuegosReunidos juegosReunidos){
        super(juegosReunidos);
    }

    @Override
    protected void mostrarOpciones(){
        super.mostrarOpciones();
        String cuartaOpción = "Introduce un 4 si quieres jugar al Ahorcado Inglés.\n";
        System.out.println(cuartaOpción);
    }

    @Override
    protected boolean chequeoOpcion(int opcion){
        return super.chequeoOpcion(opcion)||opcion==4;
    }

}

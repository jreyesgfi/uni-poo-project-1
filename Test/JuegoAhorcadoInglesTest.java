import App.JuegoAhorcadoIngles;
import Entrada.MyInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

class JuegoAhorcadoInglesTest {
    JuegoAhorcadoIngles juego;
    ArrayList<String> diccionario;

    @BeforeEach
    void setUp() {
        ArrayList<String> diccionario = MyInput.leeFichero("diccionario.txt");
        juego = new JuegoAhorcadoIngles(3, diccionario, 5); // Index 5 corresponds to "extreme"
        juego.reiniciaPartida();
    }

    @Test
    void testCorrectGuess() {
        assertTrue(juego.juega("e"), "Debes seguir jugando si la letra está en la palabra oculta pero aun faltan letras por revelar");
        assertEquals(Arrays.asList('e','_', '_',  '_', 'e', '_', 'e'), juego.getGuiones(), "Las letras deben revelarse cuando están en la palabra.");
    }

    @Test
    void testFallar() {
        assertTrue(juego.juega("z"), "Debes poder seguir jugando mientras tengas vidas.");
        assertEquals(2, juego.getVidasRestantes(), "Las vidas se deben reducir cuando fallas.");
        assertEquals(Arrays.asList('_','_', '_',  '_', '_', '_', '_'), juego.getGuiones(), "Las letras SOLO deben revelarse cuando están en la palabra.");
    }

    @Test
    void testVictoria() {
        juego.juega("t");
        juego.juega("e");
        juego.juega("x");
        juego.juega("r");
        juego.juega("s");
        assertFalse(juego.juega("m"), "El juego finaliza cuando ganas.");
        assertEquals(juego.getRecord(), 2, "Cuando ganas se debe actualizar el record.");
    }
    @Test
    void testJugarMuerto() { // Deberíamos asegurar que una vez que se acaba el juego no se puede jugar hasta reiniciarse
        juego.juega("t");
        juego.juega("e");
        juego.juega("x");
        juego.juega("r");
        juego.juega("s");
        assertFalse(juego.juega("m"), "El juego finaliza cuando ganas.");
        assertTrue(juego.juega("b"), "El juego finaliza cuando ganas.");
        assertFalse(juego.juega("e"), "El juego finaliza cuando ganas.");
        assertEquals(juego.getRecord(), 2, "Cuando ganas se debe actualizar el record.");
    }

    @Test
    void testActualizaRecord() {
        juego.juega("e");
        juego.juega("x");
        juego.juega("t");
        juego.juega("r");
        assertFalse(juego.juega("m"), "El juego finaliza cuando ganas.");
        assertEquals(juego.getRecord(), 3, "Se debe haber actualizado el record.");
    }

    @Test
    void testPerderJuego() {
        juego.juega("e");
        juego.juega("x");
        juego.juega("t");
        juego.juega("r");
        juego.juega("m");
        juego.reiniciaPartida();
        juego.juega("w");
        juego.juega("u");
        assertFalse(juego.juega("z"), "Debes perder el juego si te quedas sin vidas.");
        assertEquals(juego.getRecord(),3, "El record no se debe actualizar si has perdido.");
        assertEquals(juego.getVidasRestantes(),0, "Tus vidas deben permanecer a 0 hasta que se reinicie el juego.");
    }

    @Test
    void testPalabraDiferente() {

    // Caso positivo
    JuegoAhorcadoIngles juegoMode = new JuegoAhorcadoIngles(3, diccionario, 4); // "mode"
        juegoMode.reiniciaPartida();
        juegoMode.juega("o");
        juegoMode.juega("d");
        juegoMode.juega("t");
        juegoMode.juega("e");
    assertFalse(juegoMode.juega("m"), "El juego finaliza cuando ganas.");
    assertEquals(3, juegoMode.getRecord(), "Se debe haber actualizado el record tras ganar.");

    // Caso negativo
        juegoMode.reiniciaPartida();
    assertTrue(juegoMode.juega("a"), "El juego debe continuar después de un intento incorrecto.");
    assertEquals(2, juegoMode.getVidasRestantes(), "Las vidas deben decrementarse correctamente tras un intento incorrecto.");
    juegoMode.juega("q");
    assertFalse(juegoMode.juega("f"), "Debes perder el juego si te quedas sin vidas.");
    assertEquals(juegoMode.getRecord(),3, "El record no se debe actualizar si has perdido.");
    assertEquals(juegoMode.getVidasRestantes(),0, "Tus vidas deben permanecer a 0 hasta que se reinicie el juego.");
    }

    @Test
    void testInputMayuscula() { // la comprobación falla porque solo lo hemos contemplado en el método jugar del menú
        assertTrue(juego.juega("D"), "El juego debe manejar entradas incorrectas (Mayúsculas).");
        assertEquals(juego.getVidasRestantes(),3, "No debes perder vidas si el input no era correcto.");
    }

    // Test sin ser determinista para no entrar en bucle
    @Test
    void testDiccionarioMayuscula() {
        ArrayList<String> diccionario2 = new ArrayList<>(Arrays.asList("D", "da"));
        JuegoAhorcadoIngles juego2 = new JuegoAhorcadoIngles(3, diccionario2); // Index 5 corresponds to "ext
        juego2.reiniciaPartida();
    }

    @Test
    void testDiccionarioNumero() { // No falla, deberíamos detectarlo en la validación de palabra del diccionario
        ArrayList<String> diccionario2 = new ArrayList<>(Arrays.asList("da5"));
        JuegoAhorcadoIngles juego2 = new JuegoAhorcadoIngles(3, diccionario2); // Index 5 corresponds to "ext
        juego2.reiniciaPartida();
    }

}

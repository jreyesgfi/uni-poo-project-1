import Entrada.MyInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

class JuegoAhorcadoInglesTest {
    JuegoAhorcadoIngles game;
    ArrayList<String> diccionario;

    @BeforeEach
    void setUp() {
        ArrayList<String> diccionario = MyInput.leeFichero("diccionario.txt");
        game = new JuegoAhorcadoIngles(3, diccionario, 5); // Index 5 corresponds to "extreme"
        game.reiniciaPartida();
    }

    @Test
    void testCorrectGuess() {
        assertTrue(game.juega("e"), "Debes seguir jugando si la letra está en la palabra oculta pero aun faltan letras por revelar");
        assertEquals(Arrays.asList('e','_', '_',  '_', 'e', '_', 'e'), game.getGuiones(), "Las letras deben revelarse cuando están en la palabra.");
    }

    @Test
    void testFallar() {
        assertTrue(game.juega("z"), "Debes poder seguir jugando mientras tengas vidas.");
        assertEquals(2, game.getVidasRestantes(), "Las vidas se deben reducir cuando fallas.");
        assertEquals(Arrays.asList('_','_', '_',  '_', '_', '_', '_'), game.getGuiones(), "Las letras SOLO deben revelarse cuando están en la palabra.");
    }

    @Test
    void testVictoria() {
        game.juega("t");
        game.juega("e");
        game.juega("x");
        game.juega("r");
        game.juega("s");
        assertFalse(game.juega("m"), "El juego finaliza cuando ganas.");
        assertEquals(game.getRecord(), 2, "Cuando ganas se debe actualizar el record.");
    }
    @Test
    void testJugarMuerto() { // Deberíamos asegurar que una vez que se acaba el juego no se puede jugar hasta reiniciarse
        game.juega("t");
        game.juega("e");
        game.juega("x");
        game.juega("r");
        game.juega("s");
        assertFalse(game.juega("m"), "El juego finaliza cuando ganas.");
        assertTrue(game.juega("b"), "El juego finaliza cuando ganas.");
        assertFalse(game.juega("e"), "El juego finaliza cuando ganas.");
        assertEquals(game.getRecord(), 2, "Cuando ganas se debe actualizar el record.");
    }

    @Test
    void testActualizaRecord() {
        game.juega("e");
        game.juega("x");
        game.juega("t");
        game.juega("r");
        assertFalse(game.juega("m"), "El juego finaliza cuando ganas.");
        assertEquals(game.getRecord(), 3, "Se debe haber actualizado el record.");
    }

    @Test
    void testPerderJuego() {
        game.juega("e");
        game.juega("x");
        game.juega("t");
        game.juega("r");
        game.juega("m");
        game.reiniciaPartida();
        game.juega("w");
        game.juega("u");
        assertFalse(game.juega("z"), "Debes perder el juego si te quedas sin vidas.");
        assertEquals(game.getRecord(),3, "El record no se debe actualizar si has perdido.");
        assertEquals(game.getVidasRestantes(),0, "Tus vidas deben permanecer a 0 hasta que se reinicie el juego.");
    }

    @Test
    void testPalabraDiferente() {

    // Caso positivo
    JuegoAhorcadoIngles gameMode = new JuegoAhorcadoIngles(3, diccionario, 4); // "mode"
        gameMode.reiniciaPartida();
        gameMode.juega("o");
        gameMode.juega("d");
        gameMode.juega("t");
        gameMode.juega("e");
    assertFalse(gameMode.juega("m"), "El juego finaliza cuando ganas.");
    assertEquals(3, gameMode.getRecord(), "Se debe haber actualizado el record tras ganar.");

    // Caso negativo
        gameMode.reiniciaPartida();
    assertTrue(gameMode.juega("a"), "El juego debe continuar después de un intento incorrecto.");
    assertEquals(2, gameMode.getVidasRestantes(), "Las vidas deben decrementarse correctamente tras un intento incorrecto.");
    gameMode.juega("q");
    assertFalse(gameMode.juega("f"), "Debes perder el juego si te quedas sin vidas.");
    assertEquals(gameMode.getRecord(),3, "El record no se debe actualizar si has perdido.");
    assertEquals(gameMode.getVidasRestantes(),0, "Tus vidas deben permanecer a 0 hasta que se reinicie el juego.");
    }
}

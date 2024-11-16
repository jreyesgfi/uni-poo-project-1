import App.JuegoAdivinaNumero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JuegoAdivinaNumeroTest {
    JuegoAdivinaNumero game;

    @BeforeEach
    void setUp() {
        game = new JuegoAdivinaNumero(3, 5);
        game.reiniciaPartida();
    }

    @Test
    void testPerderVidas() {
        // El jugador adivina incorrectamente dos veces
        assertTrue(game.juega("1"), "El juego debe continuar después de un intento incorrecto.");
        assertTrue(game.juega("9"), "El juego debe continuar después de un intento incorrecto.");
        assertFalse(game.juega("2"), "El juego debe terminar después del máximo de intentos.");
        assertFalse(game.quitaVida(), "El jugador no debe tener vidas restantes.");
    }

    @Test
    void testActualizarRecord() {

        // Comprobar si el record se guarda
        assertEquals(0, game.getRecord(), "La puntuación inicial debe ser cero.");
        game.juega("8");
        assertFalse(game.juega("5"), "El jugador debe ganar al adivinar correctamente.");
        assertEquals(2, game.getRecord(), "La puntuación debe actualizarse después de ganar.");

        // Comprobar si el record se actualiza
        game.reiniciaPartida();
        game.juega("5");
        assertEquals(3,game.getRecord());
    }

    @Test
    void testDiferentesParametrosConstructor() {
        // Probar con diferentes cantidades de vidas y números
        JuegoAdivinaNumero game1 = new JuegoAdivinaNumero(7, 10);
        game1.reiniciaPartida();
        for (int i = 0; i < 6; i++) {
            assertTrue(game1.juega(""+i), "El jugador debe seguir jugando mientras tenga vidas.");
            assertEquals(game1.getVidasRestantes(),7-1-i,"Las vidas deben decrementarse correctamente.");
        }
        assertFalse(game1.juega("9"));
    }

    @Test
    void testInputNoNumerico() {
        assertTrue(game.juega("n"), "El sistema debe manejar excepciones sin arrojar error.");
    }
}

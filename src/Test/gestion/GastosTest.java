package gestion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GastosTest {

    @Test
    void comprobarGastoTrue(){
        try {
            assertEquals(1000,new Gastos().costeCom("1000"));
        } catch (Exception e) {
            fail("Fallo");
        }
    }
    // Este test debe fallar, victor hizo que "costeCom()" tire una excepcion cuando es negativo
    // cuando mi programa capture la excepcion saltará el fail()
    @Test
    void comprobarGastoFalse(){
        try {
            new Gastos().costeCom("-10");
        } catch (Exception e) {
            fail("Fallo");
        }
    }

}
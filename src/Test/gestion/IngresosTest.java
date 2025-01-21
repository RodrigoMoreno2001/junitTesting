package gestion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngresosTest {

    @Test
    void comprobarIngresoTrue(){
        try {
            assertEquals(1000,new Ingresos().gananciaCom("1000"));
        } catch (Exception e) {
            fail("Fallo");
        }
    }

    @Test
    void comprobarIngresoFalse(){
        try {
            new Ingresos().gananciaCom("-10");
        } catch (Exception e) {
            fail("Fallo");
        }
    }

}
package gestion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void comprobarDNITrue() {
        assertTrue(Main.comprobarDNI("55930437A"));
    }
    @Test
    void comprobarDNIFalse() {
        assertFalse(Main.comprobarDNI("55930437B"));
    }
}
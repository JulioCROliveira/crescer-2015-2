package br.com.cwi.crescer.maven;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatematicaTests {

    @Test
    public void testarSomaDoisValores() {
        int resultado = new Matematica().somar(2, 3);

        assertEquals(5, resultado);
    }
}

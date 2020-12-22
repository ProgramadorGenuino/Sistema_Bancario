package com.sistemabancario.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {
    
    @Test
    void testSetNumeroValido(){
        final Conta instance = new Conta();
        final String valido = "12345-6";
        instance.setNumero(valido);
        final String obtido = instance.getNumero();
        assertEquals(valido, obtido);
    }
    
//    @Test   -> Já implementado no teste abaixo.
//    void testSetNumeroInvalidoExcecao(){
//        final Conta instance = new Conta();
//        final String invalido = "123";
//        assertThrows(IllegalArgumentException.class, () -> instance.setNumero(invalido));
//    }
    
    @Test
    void testSetNumeroInvalidoArmazenado(){
        final Conta instance = new Conta();
        final String invalido = "123";
        assertThrows(IllegalArgumentException.class, () -> instance.setNumero(invalido));
        final String obtido = instance.getNumero();
        assertNotNull(invalido, obtido);
    }
    
    @Test
    void testSetNumeroNull(){
        final Conta instance = new Conta();
        assertThrows(NullPointerException.class, () -> instance.setNumero(null));
    }
    
    @Test
    void testInstanciaContaCorrentePadrao(){
        final Conta instance = new Conta();
        assertFalse(instance.isPoupanca());
    }
    
    @Test
    void testSetLimiteContaEspecial(){
        final Conta instance = new Conta();
        instance.setEspecial(true);
        final double esperado = 1000;
        instance.setLimite(esperado);
        final double obtido = instance.getLimite();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testSetLimiteContaNaoEspecial(){
        final Conta instance = new Conta();
        final double limite = 1000;
        assertThrows(IllegalStateException.class, () -> instance.setLimite(limite));
    }
    
    @Test
    void testSetLimiteContaNaoEspecialNaoArmazenado(){
        final Conta instance = new Conta();
        final double limite =1000;
        assertThrows(IllegalStateException.class, () -> instance.setLimite(limite));
        final double esperado = 0.0;
        assertEquals(esperado, instance.getLimite());
    }
    
    @Test
    void testInstanciaContaGetMovimentacoesListaVazia(){
        final Conta instance = new Conta();
        assertNotNull(instance.getMovimentacoes());
    }
}

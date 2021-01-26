package com.sistemabancario.model;

import java.util.List;
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
    
    @Test
    void testSaldoNovaConta(){
        final Conta instance = new Conta();
        final double esperado = 0;
        final double obtido = instance.getSaldo();
        assertEquals(esperado, obtido);
    }
    
    @Test 
    void testSaldoTotal(){
        final double limite = 500.6;
        final double esperado = limite;
        final Conta instance = new Conta();
        instance.setEspecial(true);
        instance.setLimite(limite);
        final double obtido = instance.getSaldoTotal();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testDepositoDinheiro(){
        final double limite = 500.6;
        final double deposito = 500.8;
        final double esperado = 1001.4;
        final Conta instance = new Conta();
        instance.setEspecial(true);
        instance.setLimite(limite);
        instance.depositoDinheiro(deposito);
        final double obtido = instance.getSaldoTotal();
        assertEquals(esperado, obtido, 0.001);
    }
    
    @Test
    void testDepositoDinheiroMovimentacaoCredito(){
        final double deposito = 500.8;
        final Conta instance = new Conta();
        instance.depositoDinheiro(deposito);
        final char esperado = 'C';
        List<Movimentacao> movimentacoes = instance.getMovimentacoes();
        final char obtido = movimentacoes.get(movimentacoes.size() - 1).getTipo();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testDepositoDinheiroMovimentacaoConfirmada(){
        final double deposito = 500.8;
        final Conta instance = new Conta();
        instance.depositoDinheiro(deposito);
        List<Movimentacao> movimentacoes = instance.getMovimentacoes();
        final boolean obtido = movimentacoes.get(movimentacoes.size() - 1).isConfirmada();
        assertTrue(obtido);
    }
    
    @Test
    void testDepositoDinheiroMovimentacaoValorAtribuido(){
        final double deposito = 500.8;
        final double esperado = deposito;
        final Conta instance = new Conta();
        instance.depositoDinheiro(deposito);
        List<Movimentacao> movimentacoes = instance.getMovimentacoes();
        final double obtido = movimentacoes.get(movimentacoes.size() - 1).getValor();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testDepositoDinheiroAddMovimentacaoFinalLista(){
        final double deposito = 500.8;
        final Conta instance = new Conta();
        instance.setId(1);
        instance.depositoDinheiro(deposito);
        final long esperado = instance.getId();
        List<Movimentacao> movimentacoes = instance.getMovimentacoes();
        final long obtido = movimentacoes.get(movimentacoes.size() - 1).getId();
        assertEquals(esperado, obtido);
    }
    
    
}

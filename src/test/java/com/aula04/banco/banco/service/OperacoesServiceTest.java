package com.aula04.banco.banco.service;

import com.aula04.banco.banco.dto.RequestCliente;
import com.aula04.banco.banco.dto.RequestDeposito;
import com.aula04.banco.banco.model.Cliente;
import com.aula04.banco.banco.model.Conta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.fail;

public class OperacoesServiceTest {

    ClienteService clienteService = new ClienteService();
    OperacoesService operacoesService = new OperacoesService();

    @Test
    public void deveDepositar(){
        RequestCliente requestCliente = new RequestCliente(
                "cinthia",
                "cinthiaqcarsoso@teste.com",
                "44934586719",
                "54353",
                3
        );
        Cliente cliente = clienteService.cadastraCliente(requestCliente);
        Conta conta = cliente.getContas().stream().findFirst().get();
        double saldo = conta.getSaldo();
        RequestDeposito requestDeposito = new RequestDeposito();
        requestDeposito.setConta(conta.getId());
        requestDeposito.setValor(2222.22);
        try {
            operacoesService.depositar(cliente.getId(), requestDeposito);
            Assertions.assertTrue((saldo+requestDeposito.getValor()) == conta.getSaldo());
        } catch (Exception e ) {
            fail("Lancou a excecao");
        }
    }

    @Test
    public void naoDeveDepositar(){
        UUID contaId = UUID.randomUUID();
        UUID id  = UUID.randomUUID();
        RequestDeposito requestDeposito = new RequestDeposito();
        requestDeposito.setConta(contaId);
        requestDeposito.setValor(2222.22);
        try {
            operacoesService.depositar(id, requestDeposito);
            fail("Não Lancou a excecao");
        } catch (Exception e ) {
        }
    }
}

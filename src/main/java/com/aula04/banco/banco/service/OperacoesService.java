package com.aula04.banco.banco.service;

import com.aula04.banco.banco.BancoAula04Application;
import com.aula04.banco.banco.dto.RequestCliente;
import com.aula04.banco.banco.dto.RequestDeposito;
import com.aula04.banco.banco.dto.RequestSaque;
import com.aula04.banco.banco.model.BancoCliente;
import com.aula04.banco.banco.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class OperacoesService {
    Random random = new Random();
    BancoCliente bancoCliente = BancoAula04Application.bancoCliente;

    public void depositar(UUID id, RequestDeposito requestDeposito) throws Exception {
        bancoCliente.deposita(id, requestDeposito);
    }
    public void sacar(UUID id, RequestSaque requestSaque) throws Exception {
        bancoCliente.sacar(id, requestSaque);
    }
}

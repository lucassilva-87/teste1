package com.programacao.web.fatec.api_fatec.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacao.web.fatec.api_fatec.entities.Cliente;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    //http://localhost:8080/api/cliente/criarCliente => POST
    @PostMapping("/criarCliente")
    public String criarCliente(@RequestBody Cliente cliente){

        return "O Cliente "+cliente.getNome()+ " de idade "+cliente.getIdade()+ " e endereço "+cliente.getEndereco()+ " foi criado.";
    }

   
}

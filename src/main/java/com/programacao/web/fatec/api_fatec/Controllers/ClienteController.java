package com.programacao.web.fatec.api_fatec.Controllers;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.programacao.web.fatec.api_fatec.entities.Cliente;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ClienteController.class.getName());

    private final List<Cliente> clientes = new ArrayList<>();
    private Long idCount = 1L;

    //http://localhost:8080/api/cliente/criarCliente => POST
    @PostMapping("/criarCliente")
    public String criarCliente(@RequestBody Cliente cliente){
        cliente.setId(idCount++);
        clientes.add(cliente);

        logger.info("Recebido JSON: Nome={}, Idade={}");
        return "O Cliente "+cliente.getNome()+ " de idade "+cliente.getIdade()+ " e endereço "+cliente.getEndereco()+ " foi criado.";
    }

    @GetMapping("/listarClientes")
    public List<Cliente> ListarClientes(){
        return clientes;
    }

    @DeleteMapping("/deletarCliente/{id}")
    public String DeletarClientes(@PathVariable Long id){
        for(Cliente cliente: clientes){
            if(cliente.getId().equals(id)){
                clientes.remove(cliente);
                return "Cliente removido com sucesso!";
            }
        }
        return "Não existe cliente com id: "+id;
    }
}

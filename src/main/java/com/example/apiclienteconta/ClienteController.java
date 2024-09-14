package com.example.apiclienteconta;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final Validator validator;

    private ClienteService clienteService;


    @Autowired
    public ClienteController(ClienteService clienteService, Validator validador){
        this.clienteService = clienteService;
        this.validator = validador;
    }

    @GetMapping("/selecionarTodos")
    public List<Cliente> buscarTodosClientes(){
        return clienteService.buscarTodosClientes();
    }

    @GetMapping("/selecionarPorNome/{nome}")
    public ResponseEntity<?> buscarPorNome(@Valid @PathVariable String nome){
        List<Cliente> clientes = this.clienteService.buscarClientePorNome(nome);
        if (clientes.size() > 0){
            return ResponseEntity.status(200).body(clientes);
        }
        else{
            return ResponseEntity.status(404).body("Não existe clientes com esse nome");
        }
    }

    @GetMapping("/selecionarPorCPF/{cpf}")
    public ResponseEntity<?> buscarPorCPF(String cpf){
        List<Cliente> clientes = clienteService.buscarClientePorCPF(cpf);
        if(clientes.size() > 0){
            return ResponseEntity.status(200).body(clientes);
        }
        else{
            return ResponseEntity.status(404).body("Não existe clientes com esse cpf");
        }
    }

    @PostMapping("/inserir")
    public ResponseEntity<?> inserirCliente(@Valid @RequestBody Cliente cliente, BindingResult erros){
        if(erros.hasErrors()){
            Map<String, String> errosTotais = new HashMap<>();
            for (FieldError erro : erros.getFieldErrors()) {
                // Coloque o nome do campo e a mensagem de erro no mapa
                errosTotais.put(erro.getField(), erro.getDefaultMessage());
            }
            return new ResponseEntity<>(errosTotais, HttpStatus.BAD_REQUEST);
        }
        clienteService.inserirCliente(cliente);
        return ResponseEntity.ok("Produto inserido com sucesso");
    }


    @PostMapping("/excluir/{id}")
    public Cliente excluirCliente(@Valid @PathVariable Long id){
        if(id < 0){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id não pode ser menor que zero");
        }
        return clienteService.deletar(id);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizaProduto(@PathVariable long id, @Valid @RequestBody Cliente clienteAtualizado, BindingResult resultado){
        return clienteService.atualizarCliente(id, clienteAtualizado);
    }

}

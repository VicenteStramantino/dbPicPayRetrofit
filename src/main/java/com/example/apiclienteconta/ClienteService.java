package com.example.apiclienteconta;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }


    public List<Cliente> buscarTodosClientes(){
        return clienteRepository.findAll();
    }

    public List<Cliente> buscarClientePorNome(String nome){
        return clienteRepository.findByNomeLikeIgnoreCase(nome);
    }

    public List<Cliente> buscarClientePorCPF(@Valid @PathVariable String cpf){
        return clienteRepository.findByCpf(cpf);
    }

    public ResponseEntity<String> inserirCliente(@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
        return ResponseEntity.ok("Cliente inserido com sucesso");
    }

    public Cliente deletar(@PathVariable Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        clienteRepository.delete(cliente);
        return cliente;
    }

    public ResponseEntity<String> atualizarCliente(@PathVariable long id, @RequestBody Cliente clienteatualizado){
        Optional<Cliente> clientes = clienteRepository.findById(id);
        if(clientes.isPresent()){
            Cliente cliente = clientes.get();
            cliente.setCpf(clienteatualizado.getCpf());
            cliente.setNome(clienteatualizado.getNome());
            cliente.setEmail(clienteatualizado.getEmail());
            cliente.setTelefone(clienteatualizado.getTelefone());
            return ResponseEntity.ok("Cliente alterado com sucesso");
        }
        return ResponseEntity.notFound().build();
    }



}

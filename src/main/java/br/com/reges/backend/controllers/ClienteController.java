package br.com.reges.backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import br.com.reges.backend.modelos.Cliente;
import br.com.reges.rdn.ClienteRdn;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente>ObterTodos(){
        
        ClienteRdn rdn = new ClienteRdn();
        return rdn.obterTodos();
    }

    @GetMapping("/clientes/{id}")
    public Cliente GetById(@PathVariable("id") int id){
        ClienteRdn rdn = new ClienteRdn();
        return rdn.obterPorId(id);
    }
}

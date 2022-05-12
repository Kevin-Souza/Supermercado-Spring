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
    
    @PostMapping("/clientes")
    public int Post(@RequestBody Cliente pcli) throws SQLException{

        ClienteRdn rdn = new ClienteRdn();
        return rdn.inserir(pcli);
    }

    @PutMapping("clientes/{id}")
    public int Put(@PathVariable(value = "id") int id,@RequestBody Cliente pCliente){
        ClienteRdn rdn = new ClienteRdn();
        if(rdn.obterPorId(id).getId()>0){
            return rdn.alterar(pCliente);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"cliente no encontrado");
        }
    }
    @DeleteMapping("clientes/{id}")
        public int Delete (@PathVariable(value="id") int id){
            ClienteRdn rdn = new ClienteRdn();
            if(rdn.obterPorId(id).getId()>0){
                return rdn.deletar(id);
            }
            else{
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"cliente no encontrado");
            }
    }
}

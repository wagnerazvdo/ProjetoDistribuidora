/**
 * 
 */
package br.com.distribuidora.controller;

import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.distribuidora.model.Cliente;
import br.com.distribuidora.repository.ClienteRepository;

/**
 * @author wagne
 *
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping
	public List<Cliente> listar() {
		return this.repository.findAll();	
	}
	
	@PutMapping("/{id}")
	public Cliente editar(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		Cliente clienteDoBancoDeDados = this.repository.findById(id).get();
		BeanUtils.copyProperties(cliente, clienteDoBancoDeDados, "id");
		this.repository.save(clienteDoBancoDeDados);
		return clienteDoBancoDeDados;
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Long id) {
		this.repository.deleteById(id);
	}
	
	
	@PostMapping
	public Cliente salvar(@RequestBody Cliente cliente) {
		return this.repository.save(cliente);
	}
	
}

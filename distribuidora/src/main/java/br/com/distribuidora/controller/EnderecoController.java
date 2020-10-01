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

import br.com.distribuidora.model.Endereco;
import br.com.distribuidora.repository.EnderecoRepository;

/**
 * @author wagne
 *
 */
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository repository;
	
	@GetMapping
	public List<Endereco> listar() {
		return this.repository.findAll();	
	}
	
	@PutMapping("/{id}")
	public Endereco editar(@PathVariable("id") Long id, @RequestBody Endereco endereco) {
		Endereco enderecoDoBancoDeDados = this.repository.findById(id).get();
		BeanUtils.copyProperties(endereco, enderecoDoBancoDeDados, "id");
		this.repository.save(enderecoDoBancoDeDados);
		return enderecoDoBancoDeDados;
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Long id) {
		this.repository.deleteById(id);
	}
	
	
	@PostMapping
	public Endereco salvar(@RequestBody Endereco endereco) {
		return this.repository.save(endereco);
	}
	
}

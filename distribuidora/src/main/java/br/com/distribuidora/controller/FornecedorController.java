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

import br.com.distribuidora.model.Fornecedor;
import br.com.distribuidora.repository.FornecedorRepository;

/**
 * @author wagne
 *
 */
@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
	
	@Autowired
	private FornecedorRepository repository;
	
	@GetMapping
	public List<Fornecedor> listar() {
		return this.repository.findAll();	
	}
	
	@PutMapping("/{id}")
	public Fornecedor editar(@PathVariable("id") Integer id, @RequestBody Fornecedor fornecedor) {
		Fornecedor fornecedorDoBancoDeDados = this.repository.findById(id).get();
		BeanUtils.copyProperties(fornecedor, fornecedorDoBancoDeDados, "id");
		this.repository.save(fornecedorDoBancoDeDados);
		return fornecedorDoBancoDeDados;
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Integer id) {
		this.repository.deleteById(id);
	}
	
	
	@PostMapping
	public Fornecedor salvar(@RequestBody Fornecedor fornecedor) {
		return this.repository.save(fornecedor);
	}
	
}

/**
 * 
 */
package br.com.distribuidora.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.distribuidora.model.Fornecedor;
import br.com.distribuidora.repository.FornecedorRepository;
import io.swagger.annotations.ApiOperation;

/**
 * @author wagne
 *
 */
@RestController
@RequestMapping("/fornecedores/api")
public class FornecedorController {
	
	@Autowired
	private FornecedorRepository repository;
	
	@GetMapping("/v1")
	public List<Fornecedor> listarv1() {
		return this.repository.findAll();	
	}
	
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Fornecedor>> Listarv2() {
		return ResponseEntity.ok().body(this.repository.findAll());
	}
	
	@PutMapping("/{id}")
	public Fornecedor editar(@PathVariable("id") Integer id, @RequestBody Fornecedor fornecedor) {
		Fornecedor fornecedorDoBancoDeDados = this.repository.findById(id).get();
		BeanUtils.copyProperties(fornecedor, fornecedorDoBancoDeDados, "id");
		this.repository.save(fornecedorDoBancoDeDados);
		return fornecedorDoBancoDeDados;
	}
	
	@DeleteMapping("/v1/{id}")
	public void remover1(@PathVariable("id") Integer id) {
		this.repository.deleteById(id);
	}
	
	
	@PostMapping("/v1")
	public Fornecedor salvarv1(@RequestBody Fornecedor fornecedor) {
		return this.repository.save(fornecedor);
	}
	
	@ApiOperation(
			value="Cadastrar um Fornecedor novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do Fornecedor.")
	
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Fornecedor> salvarv2(@RequestBody Fornecedor fornecedor) {
		return ResponseEntity.ok().body(this.repository.save(fornecedor));
	}
	
}

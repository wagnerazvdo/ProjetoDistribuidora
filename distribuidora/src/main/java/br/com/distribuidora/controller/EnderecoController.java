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

import br.com.distribuidora.model.Endereco;
import br.com.distribuidora.repository.EnderecoRepository;
import io.swagger.annotations.ApiOperation;

/**
 * @author wagne
 *
 */
@RestController
@RequestMapping("/enderecos/api")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository repository;
	
	@GetMapping("/v1")
	public List<Endereco> listar1() {
		return this.repository.findAll();	
	}
	
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Endereco>> Listarv2() {
		return ResponseEntity.ok().body(this.repository.findAll());
	}
	
	@PutMapping("/{id}")
	public Endereco editar(@PathVariable("id") Integer id, @RequestBody Endereco endereco) {
		Endereco enderecoDoBancoDeDados = this.repository.findById(id).get();
		BeanUtils.copyProperties(endereco, enderecoDoBancoDeDados, "id");
		this.repository.save(enderecoDoBancoDeDados);
		return enderecoDoBancoDeDados;
	}
	
	@DeleteMapping("/v1/{id}")
	public void deletarv1(@PathVariable("id") Integer id) {
		this.repository.deleteById(id);
	}
	
	@DeleteMapping("/v2/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public void deletarv2(@PathVariable("id") Integer id) {
			
	}
	
	@PostMapping("/v1")
	public Endereco salvarv1(@RequestBody Endereco endereco) {
		return this.repository.save(endereco);
	}
	
	@ApiOperation(
			value="Cadastrar um Endereço novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do Endereço.")
	
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Endereco> salvarv2(@RequestBody Endereco endereco) {
		return ResponseEntity.ok().body(this.repository.save(endereco));
	}	
}

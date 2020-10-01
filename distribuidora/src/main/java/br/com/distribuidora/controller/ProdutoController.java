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

import br.com.distribuidora.model.Produto;
import br.com.distribuidora.repository.ProdutoRepository;

/**
 * @author wagne
 *
 */
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public List<Produto> listar() {
		return this.repository.findAll();	
	}
	
	@PutMapping("/{id}")
	public Produto editar(@PathVariable("id") Long id, @RequestBody Produto produto) {
		Produto produtoDoBancoDeDados = this.repository.findById(id).get();
		BeanUtils.copyProperties(produto, produtoDoBancoDeDados, "id");
		this.repository.save(produtoDoBancoDeDados);
		return produtoDoBancoDeDados;
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Long id) {
		this.repository.deleteById(id);
	}
	
	
	@PostMapping
	public Produto salvar(@RequestBody Produto produto) {
		return this.repository.save(produto);
	}	

}

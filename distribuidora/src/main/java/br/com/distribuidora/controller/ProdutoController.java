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

import br.com.distribuidora.model.Produto;
import br.com.distribuidora.service.ProdutoService;
import io.swagger.annotations.ApiOperation;

/**
 * @author wagne
 *
 */
@RestController
@RequestMapping("/produtos/api")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping("/v1")
	public Produto Salvarv1(@RequestBody Produto produto) {
		this.produtoService.salvar(produto);
		return produto;
	}
	
	@ApiOperation(
			value="Cadastrar um Produto novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do Produto.")
	
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Produto> salvarv2(@RequestBody Produto produto) {
		return ResponseEntity.ok().body(this.produtoService.salvar(produto));
	}
	
	@GetMapping("/v1")
	public List<Produto> Listar(){
		return this.produtoService.listarProduto();
	}
	
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Produto>> Listarv2() {
		return ResponseEntity.ok().body(this.produtoService.listarProduto());
	}
	
	@DeleteMapping("/v1/{id}")
	public String Remover1(@PathVariable("id") Integer id) {
		this.produtoService.removerProduto(this.produtoService.buscarPorId(id));
		return "Produto informado deletado com sucesso!";
	}
	
	@DeleteMapping("/v2/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Produto> remover2(@PathVariable("id") Integer id){
		return ResponseEntity.ok().body(this.produtoService.buscarPorId(id));	
	}

 	@PutMapping("/{id}")
	public Produto buscarProdutoId(@PathVariable("id") Integer id, @RequestBody Produto produto) {
		Produto produtoBD = this.produtoService.buscarPorId(id);
		BeanUtils.copyProperties(produto, produtoBD, "id");
		this.produtoService.salvar(produtoBD);
		return produtoBD;
	}


}
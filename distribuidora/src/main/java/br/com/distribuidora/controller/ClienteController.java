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

import br.com.distribuidora.model.Cliente;
import br.com.distribuidora.service.ClienteService;
import io.swagger.annotations.ApiOperation;

/**
 * @author wagne
 *
 */

@RestController
@RequestMapping("/clientes/api")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/v1")
	public Cliente salvarv1(@RequestBody Cliente cliente) {
		return this.clienteService.Salvar(cliente);
	}
	
	@ApiOperation(
			value="Cadastrar um Cliente novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do Cliente.")
	
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Cliente> salvarv2(@RequestBody Cliente cliente) {
		return ResponseEntity.ok().body(this.clienteService.Salvar(cliente));
	}	
	
	@GetMapping("/v1")
	public List<Cliente> listarv1() {
		System.out.println("Chamando a versão 1");
		return this.clienteService.listaClientes();
	}
	
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Cliente>> Listarv2() {
		return ResponseEntity.ok().body(this.clienteService.listaClientes());
	}
	
	@DeleteMapping("/v1/{id}")
	public String remover(@PathVariable("id") Integer id) {
		this.clienteService.remover(this.clienteService.buscarPorId(id));
		return "Cliente informado deletado com sucesso!";
	}
	
	@DeleteMapping("/v2/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Cliente> remover2(@PathVariable("id") Integer id){
		return ResponseEntity.ok().body(this.clienteService.buscarPorId(id));	
	}
	
	@PutMapping("/v1/{id}")
	public Cliente buscarClienteId(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
		Cliente clienteBD = this.clienteService.buscarPorId(id);
		BeanUtils.copyProperties(cliente, clienteBD, "id");
		this.clienteService.Salvar(clienteBD);
		return clienteBD;	
	}
	
	@PutMapping("/v2/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Cliente> editarClientev2(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
		Cliente clienteBD = this.clienteService.buscarPorId(id);
		BeanUtils.copyProperties(cliente, clienteBD, "id");
		return ResponseEntity.ok().body(this.clienteService.buscarPorId(id));	
	}
	
}
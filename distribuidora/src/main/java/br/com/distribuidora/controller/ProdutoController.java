/**
 * 
 */
package br.com.distribuidora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wagne
 *
 */
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@GetMapping
	public String teste() {
		return "Estou sendo chamado pelo método GET";
	}	

}

/**
 * 
 */
package br.com.distribuidora.service;

import java.util.List;

import br.com.distribuidora.model.Cliente;

/**
 * @author wagne
 *
 */
public interface ClienteService {
	
	Cliente Salvar(Cliente cliente);
	List<Cliente> listaClientes();
	void remover(Cliente cliente);
	Cliente buscarPorId(int idCliente);

}

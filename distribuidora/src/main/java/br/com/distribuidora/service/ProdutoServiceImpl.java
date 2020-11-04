/**
 * 
 */
package br.com.distribuidora.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.distribuidora.exception.EntidadeNãoEncontradaException;
import br.com.distribuidora.model.Produto;
import br.com.distribuidora.repository.ProdutoRepository;

/**
 * @author wagne
 *
 */

@Service
public class ProdutoServiceImpl implements ProdutoService{

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	@Transactional
	public Produto salvar(Produto produto) {
		return this.produtoRepository.save(produto);
		
	}

	@Override
	public List<Produto> listarProduto() {
		return this.produtoRepository.findAll();
	}

	@Override
	@Transactional
	public void removerProduto(Produto produto) {
		this.produtoRepository.delete(produto);
		
	}

	@Override
	@Transactional
	public void removerPorId(int idProduto) {
		this.produtoRepository.deleteById(idProduto);
		
	}

	@Override
	public Produto buscarPorId(int idProduto) {
		Optional<Produto> produto = this.produtoRepository.findById(idProduto);
		if(produto.get()==null) {
			throw new EntidadeNãoEncontradaException("Não foi possível localizar o produto pesquisado!");
		} else
		return produto.get();
	}

}
/**
 * 
 */
package br.com.distribuidora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.com.distribuidora.model.Produto;

/**
 * @author wagne
 *
 */
//@Component
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}

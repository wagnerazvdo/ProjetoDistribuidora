/**
 * 
 */
package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Produto;

/**
 * @author wagne
 *
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}

/**
 * 
 */
package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Fornecedor;

/**
 * @author wagne
 *
 */
@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

}

/**
 * 
 */
package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Endereco;

/**
 * @author wagne
 *
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}

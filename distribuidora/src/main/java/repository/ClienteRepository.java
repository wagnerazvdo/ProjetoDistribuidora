/**
 * 
 */
package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Cliente;

/**
 * @author wagne
 *
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}

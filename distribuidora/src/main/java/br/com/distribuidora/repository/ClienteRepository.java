/**
 * 
 */
package br.com.distribuidora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.com.distribuidora.model.Cliente;

/**
 * @author wagne
 *
 */
//@Component
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}

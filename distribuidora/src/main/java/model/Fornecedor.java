/**
 * 
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author wagne
 *
 */
@Data
@Entity
@Table(name="tb_fornecedores")
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cnpj;
	private String email;
	private String telefone;
}

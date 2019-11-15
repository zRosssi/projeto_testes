package br.com.upf.projeto.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Cidade {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 60, nullable = false)
	@NotEmpty(message = "O nome da cidade é obrigatório!")
	@Length(min = 2, max = 60, message = "O nome da cidade deve ter entre 2 e 60 caracteres!")
	private String nome;
	
	@ManyToOne(optional = false)
	@NotNull(message = "É obrigatório informar um estado!")
	private Estado estado;
	
	
	
	private static final long serialVersionUID = 1L;

	public Cidade() {
		
	} 
	
	
	public Cidade(Integer id) {
		this.id = id;
	}


	public Cidade(Integer id,
			@NotEmpty(message = "O nome da cidade é obrigatório!") @Length(min = 2, max = 60, message = "O nome da cidade deve ter entre 2 e 60 caracteres!") String nome,
			@NotNull(message = "É obrigatório informar um estado!") Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}

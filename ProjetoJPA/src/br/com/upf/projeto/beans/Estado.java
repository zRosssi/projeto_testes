package br.com.upf.projeto.beans;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 60, nullable = false, unique=true)
	@NotEmpty(message = "O nome do Estado é obrigatório!")
	@Length(min = 2, max = 60, message = "O nome do Estado deve ter entre 2 e 60 caracteres!")
	private String Nome;
	
	@Column(length = 2, nullable = false)
	@NotEmpty(message = "É necessário informar a UF!")
	@Length(min = 2, max = 2, message = "Você deve informar os 2 caracteres da UF.")
	private String UF;
	public Estado() {
		
	}   
	
	public Estado(Integer id,
			@NotEmpty(message = "O nome do Estado é obrigatório!") @Length(min = 2, max = 60, message = "O nome do Estado deve ter entre 2 e 60 caracteres!") String nome,
			@NotEmpty(message = "É necessário informar a UF!") @Length(min = 2, max = 2, message = "Você deve informar os 2 caracteres da UF.") String uF) {
		super();
		this.id = id;
		Nome = nome;
		UF = uF;
	}
	
	
	
	

	public Estado(
			@NotEmpty(message = "O nome do Estado é obrigatório!") @Length(min = 2, max = 60, message = "O nome do Estado deve ter entre 2 e 60 caracteres!") String nome,
			@NotEmpty(message = "É necessário informar a UF!") @Length(min = 2, max = 2, message = "Você deve informar os 2 caracteres da UF.") String uF) {
		super();
		Nome = nome;
		UF = uF;
	}

	public Estado(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNome() {
		return this.Nome;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}   
	public String getUF() {
		return this.UF;
	}

	public void setUF(String UF) {
		this.UF = UF;
	}
}

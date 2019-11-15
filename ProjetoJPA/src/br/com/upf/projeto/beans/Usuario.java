package br.com.upf.projeto.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "O nome deve ser informado!")
	@Length(max = 60, min = 3, message = "O nome deve ter entre 3 e 60 caracteres!")
	@Column(length = 60, nullable = false)
	private String nome;
	@NotEmpty(message = "O login deve ser informado!")
	@Length(max = 20, min = 5, message = "O nome deve ter entre 5 e 20 caracteres!")
	@Column(length = 20, nullable = false)
	private String login;
	@NotEmpty(message = "A senha deve ser informada!")
	@Length(max = 40, min = 4, message = "O nome deve ter entre 4 e 40 caracteres!")
	@Column(length = 40, nullable = false)
	private String senha;
	@Column(nullable = false, length = 60)
	@NotEmpty(message = "O Endereco do cliente deve ser informado!")
	@Length(max = 60, message = "O Endereco deve conter no máximo {max} caracteres.")
	private String Endereco;

	@Column(length = 20)
	@Length(max = 20, message = "O telefone deve conter no máximo {max} caracteres.")
	private String Telefone;

	@Column(nullable = false, length = 14)
	@NotEmpty(message = "É obrigatório informar um CPF.")
	@Length(min = 14, max = 14, message = "É necessário informar todos os 14 caracteres para o CPF.")
	@CPF
	private String cpf;

	@ManyToOne(optional = false)
	@NotNull(message = "É obrigatório informar uma cidade!")
	private Cidade cidade;

	public Usuario() {

	}

	public Usuario(Integer id,
			@NotEmpty(message = "O nome deve ser informado!") @Length(max = 60, min = 3, message = "O nome deve ter entre 3 e 60 caracteres!") String nome,
			@NotEmpty(message = "O login deve ser informado!") @Length(max = 20, min = 5, message = "O nome deve ter entre 5 e 20 caracteres!") String login,
			@NotEmpty(message = "A senha deve ser informada!") @Length(max = 40, min = 4, message = "O nome deve ter entre 4 e 40 caracteres!") String senha,
			@NotEmpty(message = "O Endereco do cliente deve ser informado!") @Length(max = 60, message = "O Endereco deve conter no máximo {max} caracteres.") String endereco,
			@Length(max = 20, message = "O telefone deve conter no máximo {max} caracteres.") String telefone,
			@NotEmpty(message = "É obrigatório informar um CPF.") @Length(min = 14, max = 14, message = "É necessário informar todos os 14 caracteres para o CPF.") @CPF String cpf,
			@NotNull(message = "É obrigatório informar uma cidade!") Cidade cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		Endereco = endereco;
		Telefone = telefone;
		this.cpf = cpf;
		this.cidade = cidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	

}

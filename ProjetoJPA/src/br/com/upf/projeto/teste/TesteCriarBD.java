package br.com.upf.projeto.teste;

import javax.persistence.Persistence;

public class TesteCriarBD {

	
	public static void main(String[] args){
		Persistence.createEntityManagerFactory("ProjetoJPA");
	}
}

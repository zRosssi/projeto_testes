package br.com.upf.projeto.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAFactory {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjetoJPA");

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}

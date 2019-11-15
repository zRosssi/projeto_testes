package br.com.upf.projeto.teste;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import com.mchange.v2.cfg.PropertiesConfigSource.Parse;

import br.com.upf.projeto.beans.Cidade;
import br.com.upf.projeto.beans.Estado;
import br.com.upf.projeto.beans.Usuario;
import br.com.upf.projeto.jpa.JPAFactory;

public class TesteComJunit {
	
	//TESTES ESTADOS
	@Test
	public void listarEstado() {
		EntityManager em = JPAFactory.getEntityManager();
		List<Estado> lista = em.createQuery("from Estado").getResultList();
		System.out.println(lista);	
		em.close();
	} 
	

	@Test 
	public void DescricaoEstadoEmpty(){
		Estado estado = new Estado();
	//	estado.setUF("");
		Assert.assertEquals("", estado.getUF());
	}
	
	
	@Test
	public void DescricaoEstadoEquals(){
		Estado estado = new Estado();
		estado.setNome("Santa Catarina");
		estado.setUF("SC");
		
		Assert.assertEquals("Santa Catarina", estado.getNome());
		Assert.assertEquals("SC", estado.getUF());
	}
	@Test
	public void incluirEstado() {
		Estado r = new Estado(null ,"Mato Grosso", "MG");
		EntityManager em = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();// deve dar certo
	}
	
	@Test
	public void incluirEstadoErrado() {
		Estado r = new Estado(null, "MG");
		EntityManager em = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();// deve dar errado
	}


	//TESTE CIDADES
	@Test
	public void listarCidade() {
		EntityManager em = JPAFactory.getEntityManager();
		List<Cidade> lista = em.createQuery("from Cidade").getResultList();
		System.out.println(lista);	
		em.close();
	} 
	
	@Test 
	public void DescricaoCidadeEmpty(){
		Cidade cidade = new Cidade();
		Assert.assertEquals("", cidade.getNome());
	}
	
	@Test
	public void DescricaoCidadeEquals(){
		Cidade cidade = new Cidade();
		cidade.setNome("Passo Fundo");
		
		Assert.assertEquals("Passo Fundo", cidade.getNome());
	}
	

	@Test
	public void incluirCidadeErrada() {
		Cidade c = new Cidade(null, "Marau", null);
		EntityManager em = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();// deve dar errado
	}
	

	
	//TESTE USUARIOS
	@Test
	public void listarUsuario() {
		EntityManager em = JPAFactory.getEntityManager();
		List<Usuario> lista = em.createQuery("from Usuario").getResultList();
		System.out.println(lista);	
		em.close();
	} 
	
	@Test 
	public void DescricaoUsuarioEmpty(){
		Usuario usuario = new Usuario();
		Assert.assertEquals("", usuario.getNome());
	}
	
	@Test
	public void DescricaoUsuarioEquals(){
		Usuario usuario = new Usuario();
		usuario.setNome("Gustavo Rossi Tumelero");
		
		Assert.assertEquals("Gustavo Rossi Tumelero", usuario.getNome());
	}
	

	@Test
	public void incluirUsuarioErrado() {
		Usuario u = new Usuario(null ,"Av Brasil", "54999272254", "999.999.999-99", "grtumelero", "Gustavo", "123@abc", null) ;
		EntityManager em = JPAFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		em.close();// deve dar errado
	}
	
}
package com.ecodeup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ecodeup.model.Cliente;
import com.ecodeup.model.JPAUtil;

public class ClienteDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	// guardar cliente
	public void guardar(Cliente cliente) {
		entity.getTransaction().begin();
		entity.persist(cliente);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}

	// editar cliente
	public void editar(Cliente cliente) {
		entity.getTransaction().begin();
		entity.merge(cliente);
		entity.getTransaction().commit();
		/// JPAUtil.shutdown();
	}

	// buscar cliente
	public Cliente buscar(Long id) {
		Cliente c = new Cliente();
		c = entity.find(Cliente.class, id);
		// JPAUtil.shutdown();
		return c;
	}

	/// eliminar cliente
	public void eliminar(Long id) {
		Cliente c = new Cliente();
		c = entity.find(Cliente.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}

	// obtener todos los cliente
	public List<Cliente> obtenerClientes() {
		List<Cliente> listaClientes = new ArrayList<>();
		Query q = entity.createQuery("SELECT c FROM Cliente c");
		listaClientes = q.getResultList();
		return listaClientes;
	}

}

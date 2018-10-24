package com.ecodeup.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ecodeup.dao.ClienteDAO;
import com.ecodeup.model.Cliente;

@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteBean {

	public List<Cliente> obtenerClientes() {
		ClienteDAO clienteDAO= new ClienteDAO();

		/*List<Cliente> listaClientes = new ArrayList<>();
		Cliente c1 = new Cliente();
		c1.setId(1L);
		c1.setNombres("Elivar");
		c1.setApellidos("Largo");
		c1.setDireccion("Loja");

		Cliente c2 = new Cliente();
		c2.setId(1L);
		c2.setNombres("Elivar1");
		c2.setApellidos("Largo1");
		c2.setDireccion("Loja1");
		listaClientes.add(c1);
		listaClientes.add(c2);

		return listaClientes;*/
		return clienteDAO.obtenerClientes();
	}
	
	public void editar(Long id) {
		ClienteDAO clienteDAO= new ClienteDAO();
		Cliente c= new Cliente();
		c=clienteDAO.buscar(id);
		System.out.println("******************************************");		
		System.out.println(c);		
	}

	
}

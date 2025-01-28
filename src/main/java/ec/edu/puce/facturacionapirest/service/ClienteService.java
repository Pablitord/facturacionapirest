package ec.edu.puce.facturacionapirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.puce.facturacionapirest.domain.Cliente;
import ec.edu.puce.facturacionapirest.dto.v1.ClienteDTO;
import ec.edu.puce.facturacionapirest.persistence.ClientRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClientRepository clienteRepository;
	
	public List<Cliente> listarTodo(){
		return clienteRepository.findAll();
	}
	
	public void guardarNuevoCliente(ClienteDTO cliente) {
		Cliente clienteGuardado = new Cliente();
		clienteGuardado.setNombre(cliente.getNombre());
		clienteGuardado.setApellido(cliente.getApellido());
		clienteGuardado.setEmail(cliente.getEmail());
		clienteRepository.save(clienteGuardado);
	}
	
	public void actualizarCliente(ClienteDTO cliente) {
		Cliente clienteGuardado = new Cliente();
		clienteGuardado.setId(cliente.getId());
		clienteGuardado.setNombre(cliente.getNombre());
		clienteGuardado.setApellido(cliente.getApellido());
		clienteGuardado.setEmail(cliente.getEmail());
		clienteRepository.save(clienteGuardado);
	}
	
	public void eliminarCliente(Long id) {
		clienteRepository.deleteById(id);
	}
	
	public Cliente buscarPorEmail(String email) {
		return clienteRepository.findByEmail(email);
	}
	
	
	
}

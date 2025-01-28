package ec.edu.puce.facturacionapirest.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.puce.facturacionapirest.domain.Cliente;
import ec.edu.puce.facturacionapirest.dto.v1.ClienteDTO;
import ec.edu.puce.facturacionapirest.service.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/listarClientes")
	public List<Cliente> listarTodo(){
		return clienteService.listarTodo();
	}
	
	@GetMapping ("/{email}/email-cliente") //Buscar por email
	public Cliente buscarPorEmail(@PathVariable String email) {
		return clienteService.buscarPorEmail(email);
	}
	
	@PostMapping //Insertar a DB
	public String guardarNuevo(@RequestBody ClienteDTO cliente) {
		clienteService.guardarNuevoCliente(cliente);
		return "El cliente ha sido guardado correctamente";
	}
	
	@PutMapping //Actualizar a un cliente
	public String actualizarCliente(@RequestBody ClienteDTO cliente) {
		clienteService.actualizarCliente(cliente);
		return "El cliente ha sido actualizado con éxito";
	}
	
	@DeleteMapping ("/{id}/id-cliente")
	public String eliminarCliente(@PathVariable Long id) {
		clienteService.eliminarCliente(id);
		return "El cliente ha sido eliminado correctamente";
	}
	
	
}

package ec.edu.puce.facturacionapirest.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.puce.facturacionapirest.domain.Cliente;

public interface ClientRepository extends JpaRepository<Cliente, Long> {
	
	public Cliente findByEmail(String email);

}

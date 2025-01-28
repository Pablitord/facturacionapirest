package ec.edu.puce.facturacionapirest.dto.v1;

import lombok.Data;

@Data
public class ClienteDTO {
	
	private Long id;
	private String nombre;
	private String apellido;
	private String email;

}

package mongodb.model.collection;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @Data @ToString @Builder


public class Departamento {

	private String nombre;
	@Field("ubicación")
	private String ubicacion;
	
}

package mongodb.model.collection;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @Data @ToString @Builder

public class Trabajo {

	private String titulo;
	private double salario;
	@Field("fecha_inicio")
	private LocalDate fechaInicio;
	private double bonos;
	
}

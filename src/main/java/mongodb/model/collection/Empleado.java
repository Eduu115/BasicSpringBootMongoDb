package mongodb.model.collection;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @Data @ToString @Builder @EqualsAndHashCode(of="id") //eq&hc solo por si acaso, solo con el id

@Document(collection="empleados")
public class Empleado {
	@Id
	@JsonSerialize(using=ToStringSerializer.class) // <- si al montar el JSON no lo tienes(el id) con el timestamp y date,
	// te lo pone con numeros y ya serializado con solo los numeros (y no en dos partes como antes: timestamp y date)
	private ObjectId id;
	
	private String nombre;
	private int edad;
	// EmbutidoS
	private Trabajo trabajo;
	private Departamento departamento;
	private List<String> aficiones;
	
}

package mongodb.restcontroller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mongodb.model.collection.Empleado;
import mongodb.model.service.EmpleadoService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/empleados")
public class EmpleadoRestController {

	@Autowired
	private EmpleadoService es;
	
	@GetMapping("/")
	public ResponseEntity<List<Empleado>> getEmpleados(){
		return ResponseEntity.status(200).body(es.findAll()); // habria que hacer comprobaciones antes con if para segun eso dar un codigo u otro de http
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmpleado(@PathVariable ObjectId id){ // pones el ? porque no sabes que va a devolver, ya que si no existe devuelves un String en este caso en el body
		Empleado e = es.findOne(id);
		if (e == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no existe");
		
		return ResponseEntity.status(200).body(e);
		
	}
	
	@GetMapping("/salario-mayor/{salario}")
	public ResponseEntity<?> uno(@PathVariable double salario){
		return ResponseEntity.status(200).body(es.findBySalGT(salario)); // TODO: Validar Bien
	}
	
}

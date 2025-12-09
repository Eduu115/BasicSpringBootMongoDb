package mongodb.model.service;

import java.util.List;

import org.bson.types.ObjectId;

import mongodb.model.collection.Empleado;

public interface EmpleadoService {

	// CRUD
	Empleado findOne(ObjectId id);
	List<Empleado> findAll();
	Empleado insertOne(Empleado empleado);
	Empleado updateOne(Empleado empleado);
	int deleteOne(ObjectId id);
	
	//Specific
	List<Empleado> findBySalGT(double salario);
	
}

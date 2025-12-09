package mongodb.model.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mongodb.model.collection.Empleado;
import mongodb.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

	@Autowired
	EmpleadoRepository erepo;
	
	@Override
	public Empleado findOne(ObjectId id) {
		// TODO Auto-generated method stub
		return erepo.findById(id).orElse(null);
	}

	@Override
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return erepo.findAll();
	}

	@Override
	public Empleado insertOne(Empleado empleado) {
		// TODO Auto-generated method stub
		if (!erepo.existsById(empleado.getId())) {
			try {
				erepo.save(empleado);
			}catch(Exception e){
				e.getMessage();
				return null;
			}
		}
		// si ya existe
		return null;
	}

	@Override
	public Empleado updateOne(Empleado empleado) {
		if (erepo.existsById(empleado.getId())) {
			try {
				erepo.save(empleado);
			}catch(Exception e){
				e.getMessage();
				return null;
			}
		}
		// si no existe
		return null;
	}

	@Override
	public int deleteOne(ObjectId id) {
		// TODO Auto-generated method stub
		if (erepo.existsById(id)) {
			try {
				erepo.deleteById(id);
				return 1;
			}catch(Exception e){
				e.getMessage();
				return -1;
			}
		}
		// si no existe
		return 0;
	}

	@Override
	public List<Empleado> findBySalGT(double salario) {
		// TODO Auto-generated method stub
		return erepo.findByTrabajo_salarioGreaterThan(salario);
	}

}

package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Empleado;
import com.empresa.repository.EmpleadoRepository;

@Service
public class EmpleadoImpl implements EmpleadoService {

	
	@Autowired
	private EmpleadoRepository repositorio;
	
	@Override
	public Empleado insertarEmplado(Empleado objEmpleado) {
		return repositorio.save(objEmpleado);
	}

	@Override
	public List<Empleado> listaEmpleados() {
		return repositorio.findAll();
	}

}

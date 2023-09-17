package com.empresa.service;

import java.util.List;

import com.empresa.entity.Empleado;

public interface EmpleadoService {

	public Empleado insertarEmplado(Empleado objEmpleado);
	
	public List<Empleado> listaEmpleados();
}

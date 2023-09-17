package com.empresa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Empleado;
import com.empresa.service.EmpleadoService;
import com.empresa.util.AppSettings;

@RestController
@RequestMapping("/rest/empleado")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class EmpleadoController {

	@Autowired
	private EmpleadoService servicio;

	
	@GetMapping("/lista")
	@ResponseBody
	public ResponseEntity<List<Empleado>> listaEmpleados(){
		List<Empleado> lista = servicio.listaEmpleados();
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> insertaEmpleado(@RequestBody Empleado objEmpleado, Errors error) {
		Map<String, Object> salida = new HashMap<>();
		List<String> listaMensajes = new ArrayList<>();
		salida.put("error", listaMensajes);
		System.out.println("ID pais" + objEmpleado.getPais().getIdPais());
		 objEmpleado.setEstado(1);
		 objEmpleado.setFechaRegistro(new Date());
		Empleado objSalida = servicio.insertarEmplado(objEmpleado);
		if(objSalida==null) {
			listaMensajes.add("Error en el registo");
		}else {
			listaMensajes.add("Se registro el empleado de ID ==> " + objSalida.getIdEmpleado());
		}
		return ResponseEntity.ok(salida);
	}

}

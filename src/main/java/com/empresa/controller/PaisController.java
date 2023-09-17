package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Pais;
import com.empresa.service.PaisService;
import com.empresa.util.AppSettings;

@RestController
@RequestMapping("/rest/pais")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class PaisController {
	
	@Autowired
	private PaisService servicio;
	
	@GetMapping("/lista")
	@ResponseBody
	public ResponseEntity<List<Pais>> listaPais(){
		List<Pais> lista = servicio.listarPaises();
		
		return ResponseEntity.ok(lista);
	}

}

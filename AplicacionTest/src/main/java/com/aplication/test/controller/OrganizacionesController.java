/**
 * 
 */
package com.aplication.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplication.test.models.entity.Organizaciones;
import com.aplication.test.models.service.IOrganizacionesService;

/**
 * @Eduardo Valeriano
 *
 * 2 oct. 2019
 */
@RestController
@RequestMapping("/api")
public class OrganizacionesController {
	@Autowired IOrganizacionesService organizacionesService;

	// peticios getMapping para consultar todas las organizaciones	
	@GetMapping("/organizaciones")
	public List<Organizaciones> returnAllOrganizaciones(){
		return organizacionesService.findAll();			
		
	}
	

}

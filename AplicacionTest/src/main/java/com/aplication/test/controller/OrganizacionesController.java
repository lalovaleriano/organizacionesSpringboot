/**
 * 
 */
package com.aplication.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	//peticion para una sola organizacion
	@GetMapping("/organizaciones/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Organizaciones find(@PathVariable Long id) {
		return organizacionesService.findById(id);
	}
	
	//peticion para crear una organizacion
	@PostMapping("/organizaciones")
	public Organizaciones crear(@RequestBody Organizaciones org) {
		return organizacionesService.save(org);
	}

	//peticion para actualizar una organizacion
	@PutMapping("/organizaciones/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Organizaciones actualiza(@PathVariable Long id,@RequestBody Organizaciones orgRequest) {
		
		Organizaciones orgCu =  this.organizacionesService.findById(id);
		
		String nombre=orgRequest.getNombre();
		String telefono = orgRequest.getTelefono();
		String prefijo = "NE";
		String idOrg = orgCu.getId().toString();
		String numeroAutoIncremental= idExterno(nombre, telefono, prefijo, idOrg);
		
		
		
		orgCu.setNombre(orgRequest.getNombre());
		orgCu.setDireccion(orgRequest.getDireccion());
		orgCu.setTelefono(orgRequest.getTelefono());
		orgCu.setIdexterno(numeroAutoIncremental);
		organizacionesService.save(orgCu);
		
		
		return orgCu;
	}
	//peticion para eliminar una organizacion
	@DeleteMapping("organizaciones/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		organizacionesService.delete(id);
	}
	
	private String idExterno(String nombre,String telefono,String prefijo,String numero) {
		//los primeros cuattro numeros de su nombre, los ultimos 4 digitos de su telefono
		//prefijo NE y numero ingremental de 3 digitos
		String resultado="";		
			//partir el String de nombre
			String segmentar[] = nombre.split("");		
			String parteNombre= segmentar[0]+ 
					segmentar[1]+
					segmentar[2]+
					segmentar[3];
			//---------partir el String de telefono
			String segmentarTel[]= telefono.split("");
			int ultimoNum = segmentarTel.length;
			String parteTelefono = segmentarTel[ultimoNum-1]+
					segmentarTel[ultimoNum-2]+
					segmentarTel[ultimoNum-3]+
					segmentarTel[ultimoNum-4];
			
			//-------------parte numero incremental
			String incremental = String.valueOf(numero +1);			
			if(incremental.length()==1) {
				incremental = "00"+incremental;
			}else if(incremental.length()==2) {
				incremental = "0"+incremental;
			}else if(incremental.length()==3) {
				incremental = ""+incremental;
			}else {
			
		
			// me estaba tomando mas tiempo la implementacion de errores 
			// por lo cual lo maneje con un mensaje en consola
			System.out.println("el numero incremental er mayor a 3 digitos");
			}
			resultado =parteNombre + parteTelefono + prefijo + incremental;
		
		return resultado;
	}
			
}

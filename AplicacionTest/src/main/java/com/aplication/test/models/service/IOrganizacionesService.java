/**
 * 
 */
package com.aplication.test.models.service;

import java.util.List;

import com.aplication.test.models.entity.Organizaciones;

/**
 * @Eduardo Valeriano
 *
 * 2 oct. 2019
 */

public interface IOrganizacionesService {
	public List<Organizaciones> findAll();
	
	public Organizaciones findById(Long id);

	public Organizaciones save(Organizaciones org);

	public void delete(Long id);
	

}


/**
 * 
 */
package com.aplication.test.models.service.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplication.test.models.daoJPA.IOrganizaciones;
import com.aplication.test.models.entity.Organizaciones;
import com.aplication.test.models.service.IOrganizacionesService;

/**
 * @Eduardo Valeriano
 *
 * 2 oct. 2019
 */
@Service
public class OrganizacionesServiceImpl implements IOrganizacionesService {

	@Autowired IOrganizaciones organizaciones;
	
	@Override
	public List<Organizaciones> findAll() {
		
		return (List<Organizaciones>) organizaciones.findAll();
		
	}

	@Override
	public Organizaciones findById(Long id) {
	
		return organizaciones.findById(id).orElse(null);
	}

	

	@Override
	@Transactional
	public Organizaciones save(Organizaciones org) {
		return organizaciones.save(org);
	}

	@Override
	public void delete(Long id) {
		organizaciones.deleteById(id);
		
	}
	
	
	

}

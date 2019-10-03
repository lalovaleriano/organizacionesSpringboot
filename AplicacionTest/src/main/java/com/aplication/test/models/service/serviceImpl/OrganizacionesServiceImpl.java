/**
 * 
 */
package com.aplication.test.models.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplication.test.models.daoJPA.IOrganizacionesDAO;
import com.aplication.test.models.entity.Organizaciones;
import com.aplication.test.models.service.IOrganizacionesService;

/**
 * @Eduardo Valeriano
 *
 * 2 oct. 2019
 */
@Service
public class OrganizacionesServiceImpl implements IOrganizacionesService {

	@Autowired IOrganizacionesDAO organizacionesDAO;
	
	@Override
	public List<Organizaciones> findAll() {
		
		return (List<Organizaciones>) organizacionesDAO.findAll();
	}

}

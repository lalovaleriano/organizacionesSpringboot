/**
 * 
 */
package com.aplication.test.models.daoJPA;

import org.springframework.data.repository.CrudRepository;

import com.aplication.test.models.entity.Organizaciones;

/**
 * @Eduardo Valeriano
 *
 * 2 oct. 2019
 */
public interface IOrganizacionesDAO extends CrudRepository<Organizaciones, Long> {

}

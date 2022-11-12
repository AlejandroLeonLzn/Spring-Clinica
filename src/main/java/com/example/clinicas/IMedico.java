
package com.example.clinicas;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository//notacion
public interface IMedico extends CrudRepository<Medico, Integer> {
    
}

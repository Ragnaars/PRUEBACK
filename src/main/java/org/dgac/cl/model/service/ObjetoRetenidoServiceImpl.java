package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.dao.ObjetoRetenidoDAO;
import org.dgac.cl.model.entity.ObjetoRetenido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Esta anotación marca la clase como un "Servicio" en el contexto de Spring. Indica que esta clase contiene la lógica de negocio de tu aplicación.
public class ObjetoRetenidoServiceImpl implements ObjetoRetenidoService {

	@Autowired ObjetoRetenidoDAO dao; //  Esto le dice a Spring que inyecte una instancia de ObjetoRetenidoDAO en esta clase. 
	//En otras palabras, Spring crea automáticamente un objeto dao que puedes usar para interactuar con la base de datos.
	
	@Override
	public List<ObjetoRetenido> findAll() {
		return dao.findAll();
	}

	@Override
	public ObjetoRetenido findById(Long id) {

		return dao.findById(id).orElse(null);
	}

	@Override
	public ObjetoRetenido save(ObjetoRetenido objetoRetenido) {

		return dao.save(objetoRetenido);
	}

	@Override
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

}

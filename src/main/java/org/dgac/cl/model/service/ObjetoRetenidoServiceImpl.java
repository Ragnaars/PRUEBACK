package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.dao.ObjetoRetenidoDAO;
import org.dgac.cl.model.entity.ObjetoRetenido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjetoRetenidoServiceImpl implements ObjetoRetenidoService {

	@Autowired ObjetoRetenidoDAO dao;
	
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
	public void delete(ObjetoRetenido objetoRetenido) {

		dao.delete(objetoRetenido);
	}

}

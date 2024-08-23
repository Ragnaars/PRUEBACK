package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.entity.ObjetoRetenido;

public interface ObjetoRetenidoService {
	public List<ObjetoRetenido> findAll();
	public ObjetoRetenido findById(Long id);
	public ObjetoRetenido save(ObjetoRetenido objetoRetenido);
	public void deleteById(Long id);
}

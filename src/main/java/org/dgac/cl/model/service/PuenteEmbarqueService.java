package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.entity.PuenteEmbarque;

public interface PuenteEmbarqueService {

public List<PuenteEmbarque> findAll();
public PuenteEmbarque findById(Integer id);
public PuenteEmbarque save(PuenteEmbarque puenteEmbarque);
public void deleteById(Integer id);

}

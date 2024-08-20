package org.dgac.cl.model.service;

import java.util.List;

import org.dgac.cl.model.dao.PuenteEmbarqueDAO;
import org.dgac.cl.model.entity.PuenteEmbarque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PuenteEmbarqueServiceImpl implements PuenteEmbarqueService {

    @Autowired
    private PuenteEmbarqueDAO dao;

    @Override
    public List<PuenteEmbarque> findAll(){
        return dao.findAll();
    }

    @Override
    public PuenteEmbarque findById(Integer id){
        return dao.findById(id).orElse(null);
    }

    @Override
    public PuenteEmbarque save(PuenteEmbarque puenteEmbarque){
        return dao.save(puenteEmbarque);
    }

    @Override
    public void deleteById(Integer id){
        dao.deleteById(id);
    }

}

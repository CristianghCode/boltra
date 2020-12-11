package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.ExproNoOficio;
import es.sms.bolsa.repository.ExproNoOficioRepository;
import es.sms.bolsa.service.ExproNoOficioService;

@Service
@Transactional
public class ExproNoOficioServiceImpl implements ExproNoOficioService {

	@Autowired
	ExproNoOficioRepository exproNoOficioRespository;
	
	
	@Override
	public ExproNoOficio save(ExproNoOficio exproNoOficio) {
		// TODO Auto-generated method stub
		return this.exproNoOficioRespository.save(exproNoOficio);
	}

	@Override
	public List<ExproNoOficio> findAll() {
		// TODO Auto-generated method stub
		return (List<ExproNoOficio>) this.exproNoOficioRespository.findAll();
	}

	@Override
	public Optional<ExproNoOficio> findById(Long id) {
		// TODO Auto-generated method stub
		return this.exproNoOficioRespository.findById(id);
	}

	@Override
	public void delete(ExproNoOficio exproNoOficio) {
		// TODO Auto-generated method stub
		this.exproNoOficioRespository.delete(exproNoOficio);
	}

}

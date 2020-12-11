package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.ExproNoOficio;
import es.sms.bolsa.model.entity.ExproNoOficioTribunal;
import es.sms.bolsa.repository.ExproNoOficioTribunalRepository;
import es.sms.bolsa.service.ExproNoOficioTribunalService;


@Service
@Transactional
public class ExproNoOficioTribunalServiceImpl implements ExproNoOficioTribunalService {

	@Autowired
	ExproNoOficioTribunalRepository exproNoOficioTribunalRepository;
	
	
	@Override
	public ExproNoOficioTribunal save(ExproNoOficioTribunal exproNoOficioTribunal) {
		// TODO Auto-generated method stub
		return this.exproNoOficioTribunalRepository.save(exproNoOficioTribunal);
	}

	@Override
	public List<ExproNoOficioTribunal> findAll() {
		// TODO Auto-generated method stub
		return (List<ExproNoOficioTribunal>) this.exproNoOficioTribunalRepository.findAll();
	}

	@Override
	public Optional<ExproNoOficioTribunal> findByExproNoOficio(ExproNoOficio exproNoOficio) {
		// TODO Auto-generated method stub
		return this.exproNoOficioTribunalRepository.findByExproNoOficio(exproNoOficio);
	}

	@Override
	public Optional<ExproNoOficioTribunal> findById(Long id) {
		// TODO Auto-generated method stub
		return this.exproNoOficioTribunalRepository.findById(id);
	}

	@Override
	public void delete(ExproNoOficioTribunal exproNoOficioTribunal) {
		// TODO Auto-generated method stub
		this.exproNoOficioTribunalRepository.delete(exproNoOficioTribunal);
	}
}
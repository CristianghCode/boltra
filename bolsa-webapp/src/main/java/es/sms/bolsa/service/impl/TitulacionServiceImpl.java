package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.Titulacion;
import es.sms.bolsa.repository.TitulacionRepository;
import es.sms.bolsa.service.TitulacionService;


@Service
@Transactional
public class TitulacionServiceImpl implements TitulacionService {

	
	@Autowired
	TitulacionRepository titulacionRepository;
	
	
	@Override
	public Titulacion save(Titulacion titulacion) {
		// TODO Auto-generated method stub
		return this.titulacionRepository.save(titulacion);
	}

	@Override
	public List<Titulacion> findAll() {
		// TODO Auto-generated method stub
		return (List<Titulacion>) this.titulacionRepository.findAll();
	}

	@Override
	public Optional<Titulacion> findById(Long id) {
		// TODO Auto-generated method stub
		return this.titulacionRepository.findById(id);
	}

	@Override
	public void delete(Titulacion titulacion) {
		// TODO Auto-generated method stub
		this.titulacionRepository.delete(titulacion);
	}

}

package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.Investigacion;
import es.sms.bolsa.repository.InvestigacionRepository;
import es.sms.bolsa.service.InvestigacionService;


@Service
@Transactional
public class InvestigacionServiceImpl implements InvestigacionService {

	
	@Autowired
	InvestigacionRepository investigacionRepository;
	
	@Override
	public Investigacion save(Investigacion investigacion) {
		// TODO Auto-generated method stub
		return this.investigacionRepository.save(investigacion);
	}

	@Override
	public List<Investigacion> findAll() {
		// TODO Auto-generated method stub
		return (List<Investigacion>) this.investigacionRepository.findAll();
	}

	@Override
	public Optional<Investigacion> findById(Long id) {
		// TODO Auto-generated method stub
		return this.investigacionRepository.findById(id);
	}

	@Override
	public void delete(Investigacion investigacion) {
		// TODO Auto-generated method stub
		this.investigacionRepository.delete(investigacion);
	}

}

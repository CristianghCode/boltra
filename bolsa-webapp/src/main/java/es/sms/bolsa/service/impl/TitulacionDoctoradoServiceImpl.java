package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.TitulacionDoctorado;
import es.sms.bolsa.repository.TitulacionDoctoradoRepository;
import es.sms.bolsa.service.TitulacionDoctoradoService;


@Service
@Transactional
public class TitulacionDoctoradoServiceImpl implements TitulacionDoctoradoService {

	
	@Autowired
	TitulacionDoctoradoRepository titulacionDoctoradoRepository;
	
	
	@Override
	public TitulacionDoctorado save(TitulacionDoctorado titulacionDoctorado) {
		// TODO Auto-generated method stub
		return this.titulacionDoctoradoRepository.save(titulacionDoctorado);
	}

	@Override
	public List<TitulacionDoctorado> findAll() {
		// TODO Auto-generated method stub
		return (List<TitulacionDoctorado>) this.titulacionDoctoradoRepository.findAll();
	}

	@Override
	public Optional<TitulacionDoctorado> findById(Long id) {
		// TODO Auto-generated method stub
		return this.titulacionDoctoradoRepository.findById(id);
	}

	@Override
	public void delete(TitulacionDoctorado titulacionDoctorado) {
		// TODO Auto-generated method stub
		this.titulacionDoctoradoRepository.delete(titulacionDoctorado);
	}

}

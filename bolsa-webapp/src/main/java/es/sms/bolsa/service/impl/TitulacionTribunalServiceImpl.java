package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.Titulacion;
import es.sms.bolsa.model.entity.TitulacionTribunal;
import es.sms.bolsa.repository.TitulacionTribunalRepository;
import es.sms.bolsa.service.TitulacionTribunalService;


@Service
@Transactional
public class TitulacionTribunalServiceImpl implements TitulacionTribunalService {

	@Autowired
	TitulacionTribunalRepository titulacionTribunalRepository;
	
	
	@Override
	public TitulacionTribunal save(TitulacionTribunal titulacionTribunal) {
		// TODO Auto-generated method stub
		return this.titulacionTribunalRepository.save(titulacionTribunal);
	}

	@Override
	public List<TitulacionTribunal> findAll() {
		// TODO Auto-generated method stub
		return (List<TitulacionTribunal>) this.titulacionTribunalRepository.findAll();
	}

	@Override
	public Optional<TitulacionTribunal> findByTitulacion(Titulacion titulacion) {
		// TODO Auto-generated method stub
		return this.titulacionTribunalRepository.findByTitulacion(titulacion);
	}

	@Override
	public Optional<TitulacionTribunal> findById(Long id) {
		// TODO Auto-generated method stub
		return this.findById(id);
	}

	@Override
	public void delete(TitulacionTribunal titulacionTribunal) {
		// TODO Auto-generated method stub
		this.delete(titulacionTribunal);
	}

}

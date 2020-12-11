package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.TitulacionDoctorado;
import es.sms.bolsa.model.entity.TitulacionDoctoradoTribunal;
import es.sms.bolsa.repository.TitulacionDoctoradoTribunalRepository;
import es.sms.bolsa.service.TitulacionDoctoradoTribunalService;


@Service
@Transactional
public class TitulacionDoctoradoTribunalServiceImpl implements TitulacionDoctoradoTribunalService {

	
	@Autowired
	TitulacionDoctoradoTribunalRepository titulacionDoctoradoTribunalRepository;
	
	
	@Override
	public TitulacionDoctoradoTribunal save(TitulacionDoctoradoTribunal titulacionDoctoradoTribunal) {
		// TODO Auto-generated method stub
		return this.titulacionDoctoradoTribunalRepository.save(titulacionDoctoradoTribunal);
	}

	@Override
	public List<TitulacionDoctoradoTribunal> findAll() {
		// TODO Auto-generated method stub
		return (List<TitulacionDoctoradoTribunal>) this.titulacionDoctoradoTribunalRepository.findAll();
	}

	@Override
	public Optional<TitulacionDoctoradoTribunal> findByTitulacionDoctorado(TitulacionDoctorado titulacionDoctorado) {
		// TODO Auto-generated method stub
		return this.titulacionDoctoradoTribunalRepository.findByTitulacionDoctorado(titulacionDoctorado);
	}

	@Override
	public Optional<TitulacionDoctoradoTribunal> findById(Long id) {
		// TODO Auto-generated method stub
		return this.titulacionDoctoradoTribunalRepository.findById(id);
	}

	@Override
	public void delete(TitulacionDoctoradoTribunal titulacionDoctoradoTribunal) {
		// TODO Auto-generated method stub
		this.titulacionDoctoradoTribunalRepository.delete(titulacionDoctoradoTribunal);
	}

}

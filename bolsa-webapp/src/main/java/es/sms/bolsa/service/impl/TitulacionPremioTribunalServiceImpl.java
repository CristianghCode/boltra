package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.TitulacionPremio;
import es.sms.bolsa.model.entity.TitulacionPremioTribunal;
import es.sms.bolsa.repository.TitulacionPremioTribunalRepository;
import es.sms.bolsa.service.TitulacionPremioTribunalService;



@Service
@Transactional
public class TitulacionPremioTribunalServiceImpl implements TitulacionPremioTribunalService {

	
	@Autowired
	TitulacionPremioTribunalRepository titulacionPremioTribunalRepository;
	
	
	@Override
	public TitulacionPremioTribunal save(TitulacionPremioTribunal titulacionPremioTribunal) {
		// TODO Auto-generated method stub
		return this.titulacionPremioTribunalRepository.save(titulacionPremioTribunal);
	}

	@Override
	public List<TitulacionPremioTribunal> findAll() {
		// TODO Auto-generated method stub
		return (List<TitulacionPremioTribunal>) this.titulacionPremioTribunalRepository.findAll();
	}

	@Override
	public Optional<TitulacionPremioTribunal> findByTitulacionPremio(TitulacionPremio titulacionPremio) {
		// TODO Auto-generated method stub
		return this.titulacionPremioTribunalRepository.findByTitulacionPremio(titulacionPremio);
	}

	@Override
	public Optional<TitulacionPremioTribunal> findById(Long id) {
		// TODO Auto-generated method stub
		return this.titulacionPremioTribunalRepository.findById(id);
	}

	@Override
	public void delete(TitulacionPremioTribunal titulacionPremioTribunal) {
		// TODO Auto-generated method stub
		this.titulacionPremioTribunalRepository.delete(titulacionPremioTribunal);
	}

}

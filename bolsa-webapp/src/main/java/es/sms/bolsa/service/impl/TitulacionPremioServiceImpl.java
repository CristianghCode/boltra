package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.TitulacionPremio;
import es.sms.bolsa.repository.TitulacionPremioRepository;
import es.sms.bolsa.service.TitulacionPremioService;


@Service
@Transactional
public class TitulacionPremioServiceImpl implements TitulacionPremioService {

	@Autowired
	TitulacionPremioRepository titulacionPremioRepository;
	
	
	@Override
	public TitulacionPremio save(TitulacionPremio titulacionPremio) {
		// TODO Auto-generated method stub
		return this.titulacionPremioRepository.save(titulacionPremio);
	}

	@Override
	public List<TitulacionPremio> findAll() {
		// TODO Auto-generated method stub
		return (List<TitulacionPremio>) this.titulacionPremioRepository.findAll();
	}

	@Override
	public Optional<TitulacionPremio> findById(Long id) {
		// TODO Auto-generated method stub
		return this.titulacionPremioRepository.findById(id);
	}

	@Override
	public void delete(TitulacionPremio titulacionPremio) {
		// TODO Auto-generated method stub
		this.titulacionPremioRepository.delete(titulacionPremio);
	}

}

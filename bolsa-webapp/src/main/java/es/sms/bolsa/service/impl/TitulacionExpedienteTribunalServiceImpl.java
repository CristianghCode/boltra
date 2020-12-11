package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.TitulacionExpediente;
import es.sms.bolsa.model.entity.TitulacionExpedienteTribunal;
import es.sms.bolsa.repository.TitulacionExpedienteTribunalRepository;
import es.sms.bolsa.service.TitulacionExpedienteTribunalService;


@Service
@Transactional
public class TitulacionExpedienteTribunalServiceImpl implements TitulacionExpedienteTribunalService {

	
	@Autowired
	TitulacionExpedienteTribunalRepository titulaCionExpedienteTribunalRepository;
	
	
	@Override
	public TitulacionExpedienteTribunal save(TitulacionExpedienteTribunal titulacionExpedienteTribunal) {
		// TODO Auto-generated method stub
		return this.titulaCionExpedienteTribunalRepository.save(titulacionExpedienteTribunal);
	}

	@Override
	public List<TitulacionExpedienteTribunal> findAll() {
		// TODO Auto-generated method stub
		return (List<TitulacionExpedienteTribunal>) this.titulaCionExpedienteTribunalRepository.findAll();
	}

	@Override
	public Optional<TitulacionExpedienteTribunal> findByTitulacionExpediente(
			TitulacionExpediente titulacionExpediente) {
		// TODO Auto-generated method stub
		return this.titulaCionExpedienteTribunalRepository.findByTitulacionExpediente(titulacionExpediente);
	}

	@Override
	public Optional<TitulacionExpedienteTribunal> findById(Long id) {
		// TODO Auto-generated method stub
		return this.titulaCionExpedienteTribunalRepository.findById(id);
	}

	@Override
	public void delete(TitulacionExpedienteTribunal titulacionExpedienteTribunal) {
		// TODO Auto-generated method stub
		this.titulaCionExpedienteTribunalRepository.delete(titulacionExpedienteTribunal);
	}

}

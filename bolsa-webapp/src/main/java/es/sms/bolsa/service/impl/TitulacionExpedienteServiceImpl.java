package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.TitulacionExpediente;
import es.sms.bolsa.repository.TitulacionExpedienteRepository;
import es.sms.bolsa.service.TitulacionExpedienteService;


@Service
@Transactional
public class TitulacionExpedienteServiceImpl implements TitulacionExpedienteService {

	@Autowired
	TitulacionExpedienteRepository titulacionExpedienteRepository;
	
	@Override
	public TitulacionExpediente save(TitulacionExpediente titulacionExpediente) {
		// TODO Auto-generated method stub
		return this.titulacionExpedienteRepository.save(titulacionExpediente);
	}

	@Override
	public List<TitulacionExpediente> findAll() {
		// TODO Auto-generated method stub
		return (List<TitulacionExpediente>) this.titulacionExpedienteRepository.findAll();
	}

	@Override
	public Optional<TitulacionExpediente> findById(Long id) {
		// TODO Auto-generated method stub
		return this.titulacionExpedienteRepository.findById(id);
	}

	@Override
	public void delete(TitulacionExpediente titulacionExpediente) {
		// TODO Auto-generated method stub
		this.titulacionExpedienteRepository.delete(titulacionExpediente);
	}

}

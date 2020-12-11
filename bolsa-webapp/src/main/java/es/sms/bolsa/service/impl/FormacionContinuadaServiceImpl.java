package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.FormacionContinuada;
import es.sms.bolsa.repository.FormacionContinuadaRepository;
import es.sms.bolsa.service.FormacionContinuadaService;


@Service
@Transactional
public class FormacionContinuadaServiceImpl implements FormacionContinuadaService {

	
	@Autowired
	FormacionContinuadaRepository formacionContinuadaRepository;
	
	
	@Override
	public FormacionContinuada save(FormacionContinuada formacionContinuada) {
		// TODO Auto-generated method stub
		return this.formacionContinuadaRepository.save(formacionContinuada);
	}

	@Override
	public List<FormacionContinuada> findAll() {
		// TODO Auto-generated method stub
		return (List<FormacionContinuada>) this.formacionContinuadaRepository.findAll();
	}

	@Override
	public Optional<FormacionContinuada> findById(Long id) {
		// TODO Auto-generated method stub
		return this.formacionContinuadaRepository.findById(id);
	}

	@Override
	public void delete(FormacionContinuada formacionContinuada) {
		// TODO Auto-generated method stub
		this.formacionContinuadaRepository.delete(formacionContinuada);

	}

}

package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.FormacionContinuada;
import es.sms.bolsa.model.entity.FormacionContinuadaTribunal;
import es.sms.bolsa.repository.FormacionContinuadaTribunalRepository;
import es.sms.bolsa.service.FormacionContinuadaTribunalService;


@Service
@Transactional
public class FormacionContinuadaTribunalServiceImpl implements FormacionContinuadaTribunalService {

	
	@Autowired
	FormacionContinuadaTribunalRepository formacionContinuadaTribunalRepository;
	
	
	@Override
	public FormacionContinuadaTribunal save(FormacionContinuadaTribunal formacionContinuadaTribunal) {
		// TODO Auto-generated method stub
		return this.formacionContinuadaTribunalRepository.save(formacionContinuadaTribunal);
	}

	@Override
	public List<FormacionContinuadaTribunal> findAll() {
		// TODO Auto-generated method stub
		return (List<FormacionContinuadaTribunal>) this.formacionContinuadaTribunalRepository.findAll();
	}

	@Override
	public Optional<FormacionContinuadaTribunal> findByFormacionContinuada(FormacionContinuada formacionContinuada) {
		// TODO Auto-generated method stub
		return this.formacionContinuadaTribunalRepository.findByFormacionContinuada(formacionContinuada);
	}

	@Override
	public Optional<FormacionContinuadaTribunal> findById(Long id) {
		// TODO Auto-generated method stub
		return this.formacionContinuadaTribunalRepository.findById(id);
	}

	@Override
	public void delete(FormacionContinuadaTribunal formacionContinuadaTribunal) {
		// TODO Auto-generated method stub
		this.formacionContinuadaTribunalRepository.delete(formacionContinuadaTribunal);
	}

}

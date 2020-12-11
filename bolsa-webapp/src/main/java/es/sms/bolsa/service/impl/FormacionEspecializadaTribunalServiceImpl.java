package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.FormacionEspecializada;
import es.sms.bolsa.model.entity.FormacionEspecializadaTribunal;
import es.sms.bolsa.repository.FormacionEspecializadaTribunalRepository;
import es.sms.bolsa.service.FormacionEspecializadaTribunalService;


@Service
@Transactional
public class FormacionEspecializadaTribunalServiceImpl implements FormacionEspecializadaTribunalService {

	@Autowired
	FormacionEspecializadaTribunalRepository formacionEspecializadaTribunalRepository;
	
	
	
	@Override
	public FormacionEspecializadaTribunal save(FormacionEspecializadaTribunal FormacionEspecializadaTribunal) {
		// TODO Auto-generated method stub
		return this.formacionEspecializadaTribunalRepository.save(FormacionEspecializadaTribunal);
	}

	@Override
	public List<FormacionEspecializadaTribunal> findAll() {
		// TODO Auto-generated method stub
		return (List<FormacionEspecializadaTribunal>) this.formacionEspecializadaTribunalRepository.findAll();
	}

	@Override
	public Optional<FormacionEspecializadaTribunal> findByFormacionEspecializada(
			FormacionEspecializada formacionEspecializada) {
		// TODO Auto-generated method stub
		return this.formacionEspecializadaTribunalRepository.findByFormacionEspecializada(formacionEspecializada);
	}

	@Override
	public Optional<FormacionEspecializadaTribunal> findById(Long id) {
		// TODO Auto-generated method stub
		return this.formacionEspecializadaTribunalRepository.findById(id);
	}

	@Override
	public void delete(FormacionEspecializadaTribunal formacionEspecializadaTribunal) {
		// TODO Auto-generated method stub
		this.formacionEspecializadaTribunalRepository.delete(formacionEspecializadaTribunal);
	}

}

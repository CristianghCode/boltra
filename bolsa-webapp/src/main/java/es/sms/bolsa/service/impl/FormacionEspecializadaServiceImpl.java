package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.FormacionEspecializada;
import es.sms.bolsa.repository.FormacionEspecializadaRepository;
import es.sms.bolsa.service.FormacionEspecializadaService;


@Service
@Transactional
public class FormacionEspecializadaServiceImpl implements FormacionEspecializadaService {

	
	@Autowired
	FormacionEspecializadaRepository formacionEspecializadaRepository;
	
	
	@Override
	public FormacionEspecializada save(FormacionEspecializada formacionEspecializada) {
		// TODO Auto-generated method stub
		return this.formacionEspecializadaRepository.save(formacionEspecializada);
	}

	@Override
	public List<FormacionEspecializada> findAll() {
		// TODO Auto-generated method stub
		return (List<FormacionEspecializada>) this.formacionEspecializadaRepository.findAll();
	}

	@Override
	public Optional<FormacionEspecializada> findById(Long id) {
		// TODO Auto-generated method stub
		return this.formacionEspecializadaRepository.findById(id);
	}

	@Override
	public void delete(FormacionEspecializada formacionEspecializada) {
		// TODO Auto-generated method stub
		this.formacionEspecializadaRepository.delete(formacionEspecializada);
	}

}

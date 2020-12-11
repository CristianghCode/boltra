package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.InternoResidente;
import es.sms.bolsa.model.entity.InternoResidenteTribunal;
import es.sms.bolsa.repository.InternoResidenteRepository;
import es.sms.bolsa.service.InternoResidenteService;
import es.sms.bolsa.service.InternoResidenteTribunalService;


@Service
@Transactional
public class InternoResidenteServiceImpl implements InternoResidenteService {

	@Autowired
	InternoResidenteRepository internoResidenteRepository;

	@Override
	public InternoResidente save(InternoResidente internoResidente) {
		// TODO Auto-generated method stub
		return this.internoResidenteRepository.save(internoResidente);
	}

	@Override
	public List<InternoResidente> findAll() {
		// TODO Auto-generated method stub
		return (List<InternoResidente>) this.internoResidenteRepository.findAll();
	}

	@Override
	public Optional<InternoResidente> findById(Long id) {
		// TODO Auto-generated method stub
		return this.internoResidenteRepository.findById(id);
	}

	@Override
	public void delete(InternoResidente internoResidente) {
		// TODO Auto-generated method stub
		this.internoResidenteRepository.delete(internoResidente);
	}

	
	
}

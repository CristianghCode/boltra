package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.InternoResidente;
import es.sms.bolsa.model.entity.InternoResidenteTribunal;
import es.sms.bolsa.repository.InternoResidenteTribunalRepository;
import es.sms.bolsa.service.InternoResidenteTribunalService;


@Service
@Transactional
public class InternoResidenteTribunalServiceImpl implements InternoResidenteTribunalService {
	
	@Autowired
	InternoResidenteTribunalRepository internoResidenteTribunalRepository;

	@Override
	public InternoResidenteTribunal save(InternoResidenteTribunal internoResidenteTribunal) {
		// TODO Auto-generated method stub
		return this.internoResidenteTribunalRepository.save(internoResidenteTribunal);
	}

	@Override
	public List<InternoResidenteTribunal> findAll() {
		// TODO Auto-generated method stub
		return (List<InternoResidenteTribunal>) this.internoResidenteTribunalRepository.findAll();
	}

	@Override
	public Optional<InternoResidenteTribunal> findByInternoResidente(InternoResidente internoResidente) {
		// TODO Auto-generated method stub
		return this.internoResidenteTribunalRepository.findByInternoResidente(internoResidente);
	}

	@Override
	public Optional<InternoResidenteTribunal> findById(Long id) {
		// TODO Auto-generated method stub
		return this.internoResidenteTribunalRepository.findById(id);
	}

	@Override
	public void delete(InternoResidenteTribunal internoResidenteTribunal) {
		// TODO Auto-generated method stub
		this.internoResidenteTribunalRepository.delete(internoResidenteTribunal);
	}

}

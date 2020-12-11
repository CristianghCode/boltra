package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.RelacionFijeza;
import es.sms.bolsa.model.entity.RelacionFijezaTribunal;
import es.sms.bolsa.repository.RelacionFijezaTribunalRepository;
import es.sms.bolsa.service.RelacionFijezaTribunalService;


@Service
@Transactional
public class RelacionFijezaTribunalServiceImpl implements RelacionFijezaTribunalService {

	@Autowired
	RelacionFijezaTribunalRepository relacionFijezaTribunalRepository;
	
	
	
	@Override
	public RelacionFijezaTribunal save(RelacionFijezaTribunal relacionFijezaTribunal) {
		// TODO Auto-generated method stub
		return this.relacionFijezaTribunalRepository.save(relacionFijezaTribunal);
	}

	@Override
	public List<RelacionFijezaTribunal> findAll() {
		// TODO Auto-generated method stub
		return (List<RelacionFijezaTribunal>) this.relacionFijezaTribunalRepository.findAll();
	}

	@Override
	public Optional<RelacionFijezaTribunal> findByRelacionFijeza(RelacionFijeza relacionFijeza) {
		// TODO Auto-generated method stub
		return this.relacionFijezaTribunalRepository.findByRelacionFijeza(relacionFijeza);
	}

	@Override
	public Optional<RelacionFijezaTribunal> findById(Long id) {
		// TODO Auto-generated method stub
		return this.relacionFijezaTribunalRepository.findById(id);
	}

	@Override
	public void delete(RelacionFijezaTribunal relacionFijezaTribunal) {
		// TODO Auto-generated method stub

	}

}

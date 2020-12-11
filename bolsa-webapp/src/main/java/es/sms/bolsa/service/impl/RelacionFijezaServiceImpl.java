package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.RelacionFijeza;
import es.sms.bolsa.repository.RelacionFijezaRepository;
import es.sms.bolsa.service.RelacionFijezaService;


@Service
@Transactional
public class RelacionFijezaServiceImpl implements RelacionFijezaService {

	
	@Autowired
	RelacionFijezaRepository relacionFijezaRepository;
	
	
	@Override
	public RelacionFijeza save(RelacionFijeza relacionFijeza) {
		// TODO Auto-generated method stub
		return this.relacionFijezaRepository.save(relacionFijeza);
	}

	@Override
	public List<RelacionFijeza> findAll() {
		// TODO Auto-generated method stub
		return (List<RelacionFijeza>) this.relacionFijezaRepository.findAll();
	}

	@Override
	public Optional<RelacionFijeza> findById(Long id) {
		// TODO Auto-generated method stub
		return this.relacionFijezaRepository.findById(id);
	}

	@Override
	public void delete(RelacionFijeza relacionFijeza) {
		// TODO Auto-generated method stub
		this.relacionFijezaRepository.delete(relacionFijeza);
	}

}

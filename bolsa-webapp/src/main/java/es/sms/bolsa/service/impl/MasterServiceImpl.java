package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.Master;
import es.sms.bolsa.repository.MasterRepository;
import es.sms.bolsa.service.MasterService;

@Service
@Transactional
public class MasterServiceImpl implements MasterService {

	
	@Autowired
	private MasterRepository masterRepository;
	
	@Override
	public Master save(Master master) {
		// TODO Auto-generated method stub
		return masterRepository.save(master);
	}

	@Override
	public List<Master> findAll() {
		// TODO Auto-generated method stub
		return (List<Master>) masterRepository.findAll();
	}

	@Override
	public Optional<Master> findById(Long id) {
		// TODO Auto-generated method stub
		return masterRepository.findById(id);
	}

	@Override
	public void delete(Master master) {
		masterRepository.delete(master);
	}
	

}

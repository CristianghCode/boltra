package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.Item;
import es.sms.bolsa.model.entity.Master;
import es.sms.bolsa.model.entity.MasterTribunal;
import es.sms.bolsa.repository.MasterTribunalRepository;
import es.sms.bolsa.service.MasterTribunalService;

@Service
@Transactional
public class MasterTribunalServiceImpl implements MasterTribunalService {

	
	@Autowired
	MasterTribunalRepository masterTribunalRepository;
	
	
	@Override
	public MasterTribunal save(MasterTribunal masterTribunal) {
		return this.masterTribunalRepository.save(masterTribunal);
	}

	@Override
	public List<MasterTribunal> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MasterTribunal> findById(Long id) {
		// TODO Auto-generated method stub
		return this.masterTribunalRepository.findById(id);
	}

	@Override
	public void delete(MasterTribunal masterTribunal) {
		// TODO Auto-generated method stub
		this.masterTribunalRepository.delete(masterTribunal);
	}

	@Override
	public Optional<MasterTribunal> findByMaster(Master opositor) {
		// TODO Auto-generated method stub
		return this.masterTribunalRepository.findByMaster(opositor);
	}

}

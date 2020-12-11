package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.Investigacion;
import es.sms.bolsa.model.entity.InvestigacionTribunal;
import es.sms.bolsa.repository.InvestigacionTribunalRepository;
import es.sms.bolsa.service.InvestigacionTribunalService;


@Service
@Transactional
public class InvestigacionTribunalServiceImpl implements InvestigacionTribunalService {

	@Autowired
	InvestigacionTribunalRepository investigacionTribunalRepository;
	
	
	@Override
	public InvestigacionTribunal save(InvestigacionTribunal investigacionTribunal) {
		// TODO Auto-generated method stub
		return this.investigacionTribunalRepository.save(investigacionTribunal);
	}

	@Override
	public List<InvestigacionTribunal> findAll() {
		// TODO Auto-generated method stub
		return (List<InvestigacionTribunal>) this.investigacionTribunalRepository.findAll();
	}

	@Override
	public Optional<InvestigacionTribunal> findByInvestigacion(Investigacion investigacion) {
		// TODO Auto-generated method stub
		return this.investigacionTribunalRepository.findByInvestigacion(investigacion);
	}

	@Override
	public Optional<InvestigacionTribunal> findById(Long id) {
		// TODO Auto-generated method stub
		return this.investigacionTribunalRepository.findById(id);
	}

	@Override
	public void delete(InvestigacionTribunal investigacionTribunal) {
		// TODO Auto-generated method stub
		this.investigacionTribunalRepository.delete(investigacionTribunal);
	}

}

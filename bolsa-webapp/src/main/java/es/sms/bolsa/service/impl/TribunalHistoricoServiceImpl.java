package es.sms.bolsa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.sms.bolsa.model.entity.TribunalHistorico;
import es.sms.bolsa.repository.TribunalHistoricoRepository;
import es.sms.bolsa.service.TribunalHistoricoService;

@Service
@Transactional
public class TribunalHistoricoServiceImpl implements TribunalHistoricoService {

	@Autowired
	TribunalHistoricoRepository tribunalHistoricoRepository;
	
	@Override
	public TribunalHistorico save(TribunalHistorico tribunalHistorico) {
		// TODO Auto-generated method stub
		return this.tribunalHistoricoRepository.save(tribunalHistorico);
	}

	@Override
	public List<TribunalHistorico> findAll() {
		// TODO Auto-generated method stub
		return (List<TribunalHistorico>) this.tribunalHistoricoRepository.findAll();
	}

	@Override
	public Optional<TribunalHistorico> findById(Long id) {
		// TODO Auto-generated method stub
		return this.tribunalHistoricoRepository.findById(id);
	}

	@Override
	public void delete(TribunalHistorico tribunalHistorico) {
		// TODO Auto-generated method stub
		this.tribunalHistoricoRepository.delete(tribunalHistorico);
	}

}

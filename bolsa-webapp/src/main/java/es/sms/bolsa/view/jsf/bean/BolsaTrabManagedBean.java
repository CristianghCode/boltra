package es.sms.bolsa.view.jsf.bean;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;

import es.carm.sms.lobo2.web.jsf.MessagesController;
import es.sms.bolsa.model.entity.BolsaTrab;
import es.sms.bolsa.service.BolsaTrabService;

@Controller
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BolsaTrabManagedBean {


	private static final Logger logger = LoggerFactory.getLogger(BolsaTrabManagedBean.class);

	@Autowired
	private BolsaTrabService bolsaTrabService;
	@Autowired
	private MessagesController messagesController;
	
	private List<BolsaTrab> listBolsaTrab;

	@PostConstruct
	public void init() {
		listBolsaTrab = bolsaTrabService.findAll();
	}

	public List<BolsaTrab> getListBolsaTrab() {
		return listBolsaTrab;
	}

	public void setListBolsaTrab(List<BolsaTrab> listBolsaTrab) {
		this.listBolsaTrab = listBolsaTrab;
	}
	

}

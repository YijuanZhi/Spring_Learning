package com.antra.service;

import com.antra.aop.LogTime;
import com.antra.repository.MyDAO;
import com.antra.repository.MyDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MyServiceImpl implements MyService{


	@Autowired
	@Qualifier("myDAOImpl")
	private MyDAO myDAO;

	@LogTime
	public int getTicketPrice() {
		return myDAO.getSomething();
	}
}

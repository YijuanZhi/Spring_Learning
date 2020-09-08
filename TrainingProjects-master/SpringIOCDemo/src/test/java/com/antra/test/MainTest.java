package com.antra.test;

import com.antra.config.MyConfig;
import com.antra.service.MyService;
import com.antra.service.MyServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(MyConfig.class);
		MyService myService = ac.getBean(MyService.class);
		MyService myService2 = ac.getBean(MyService.class);
		System.out.println(myService.getTicketPrice());
//		int price = myService.getTicketPrice();
//		System.out.println(price);

//		MyService ms = new MyServiceImpl();
//		ms.getTicketPrice();
	}


}



//Injection Types
//@Scope
//@Qualifier
//@Primary
//@PostConstruct
//@PreDestroy

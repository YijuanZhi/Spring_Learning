package com.antra.repository;

import com.antra.aop.LogTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class MyDAOImpl2 implements MyDAO {

	private String message = "impl2";

	@LogTime
	public int getSomething() {
		System.out.println(message);
		return 100;
	}
}

package com.zensar.olxapplication;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Order(1)
public class MyApplicationRunner implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		String[] sourceargs=args.getSourceArgs();
		System.out.println("MyApplicationRunner :"+Arrays.toString(sourceargs));
		
	}

}

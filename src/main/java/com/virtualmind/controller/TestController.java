package com.virtualmind.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.virtualmind.service.TestService;

@Named
@RequestScoped
public class TestController {

	@Inject
	private TestService service;

	@PostConstruct
	public void init() {
		System.out.println("Probar");
	}

	public void buttonAction() {
		service.callUpdateTopic();
	}

}

package br.com.resteasy.app.controller;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.resteasy.app.ApplicationProperties;

public abstract class BaseController {
	
	@Autowired
	protected ApplicationProperties applicationProperties;


}

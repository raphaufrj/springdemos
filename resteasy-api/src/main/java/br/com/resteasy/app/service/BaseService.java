package br.com.resteasy.app.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public abstract class BaseService {

	public abstract String getCollectionName();
	
	private static final int PAGINATION_START = 0;
	private static final int PAGINATION_SIZE = 1;
	
	public PageRequest getPageRequest(Sort sort) {
		
		return PageRequest.of(PAGINATION_START, PAGINATION_SIZE, sort);
	}
	
	public PageRequest getPageRequest(int start, int size, Sort sort) {
		
		return PageRequest.of(start, size, sort);
	}
}

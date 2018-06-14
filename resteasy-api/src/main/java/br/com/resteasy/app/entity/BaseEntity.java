package br.com.resteasy.app.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String _id;

	public String getId() {
		return _id;
	}

	public void setId(String _id) {
		this._id = _id;
	}
	
	@Transient
	public boolean isNew() {
		
		return (_id == null || "".equals(_id) || "0".equals(_id) || "null".equalsIgnoreCase(_id));
	}
	
}

package com.cloud4soa.facetedsearch.shared;

import java.io.Serializable;

public class Provider implements Serializable{

	private static final long serialVersionUID = -4521623285162903599L;
	private String offer;
	private String provider;
	private String description;
	
	public Provider(){}
	
	public Provider(String offer, String provider, String description){
		this.offer = offer;
		this.provider = provider;
		this.description = description;
	}
	
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}

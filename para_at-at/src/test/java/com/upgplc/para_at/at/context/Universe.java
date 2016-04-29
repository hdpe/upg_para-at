package com.upgplc.para_at.at.context;

import org.springframework.stereotype.Component;

import com.upgplc.para_at.at.util.AliasStore;

@Component
public class Universe {

	private AliasStore<Long> companyIds = new AliasStore<>();
	
	private AliasStore<Long> taxiIds = new AliasStore<>();
	
	private AliasStore<Long> journeyIds = new AliasStore<>();
	
	public AliasStore<Long> companyIds() {
		return companyIds;
	}
	
	public AliasStore<Long> taxiIds() {
		return taxiIds;
	}
	
	public AliasStore<Long> journeyIds() {
		return journeyIds;
	}
}

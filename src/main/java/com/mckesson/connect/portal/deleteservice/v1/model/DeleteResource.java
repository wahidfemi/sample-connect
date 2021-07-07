package com.mckesson.connect.portal.deleteservice.v1.model;

import java.util.ArrayList;

public class DeleteResource {
	private String userId;
	private ArrayList<String> accounts;
	private String action;
	private ArrayList<String> appNames;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ArrayList<String> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<String> accounts) {
		this.accounts = accounts;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public ArrayList<String> getAppNames() {
		return appNames;
	}
	public void setAppNames(ArrayList<String> appNames) {
		this.appNames = appNames;
	}
	
	
}

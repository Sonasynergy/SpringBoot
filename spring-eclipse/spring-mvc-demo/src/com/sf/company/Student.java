package com.sf.company;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstName;
	private String lastName;
	private String Country;
	private String favoriteLanguage;
	private String operatingSystems;
	
	private LinkedHashMap<String,String> countryOptions;
	
	public Student() {
		countryOptions=new LinkedHashMap<>();
		countryOptions.put("IN", "India");
		countryOptions.put("BR", "Brazil");
		countryOptions.put("IT", "Italy");
		countryOptions.put("GER", "Germany");
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}
	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}
	public String getOperatingSystems() {
		return operatingSystems;
	}
	public void setOperatingSystems(String operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
	
	
	
	
	
	

}

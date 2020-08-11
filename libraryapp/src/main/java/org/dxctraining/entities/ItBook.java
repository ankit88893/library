package org.dxctraining.dao;

import org.dxctraining.entities.Book;

public class ItBook extends Book {
	
	String language;
	double version;
	
	ItBook(String name, String language,double version){
		super(name);
		this.language=language;
		this.version=version;
		
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItBook other = (ItBook) obj;
		if (Double.doubleToLongBits(version) != Double.doubleToLongBits(other.version))
			return false;
		return true;
	}
	


}

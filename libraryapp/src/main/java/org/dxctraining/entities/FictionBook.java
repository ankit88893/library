package org.dxctraining.dao;
import org.dxctraining.entities.*;

public class FictionBook extends Book {

	String characterName;

	FictionBook(String name, String characterName) {
		super(name);
		this.characterName = characterName;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FictionBook other = (FictionBook) obj;
		if (characterName == null) {
			if (other.characterName != null)
				return false;
		} else if (!characterName.equals(other.characterName))
			return false;
		return true;
	}
	
	
}

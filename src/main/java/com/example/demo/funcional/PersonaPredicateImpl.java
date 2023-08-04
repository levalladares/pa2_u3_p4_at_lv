package com.example.demo.funcional;

public class PersonaPredicateImpl implements IPersonaPredicate<String>{

	@Override
	public boolean evaluar(String arg) {
		// TODO Auto-generated method stub
		char primerCaracter = arg.charAt(0);
		if(Character.isUpperCase(primerCaracter)) {
			return true;
		}
		return false;
	}

}

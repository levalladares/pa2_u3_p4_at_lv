package com.example.demo.funcional;

public class PersonaSupplierImpl implements IPersonaSupplier<String> {

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		String cedula="17239737966";
		cedula= cedula+"zzzzzzzzzz";
		return cedula;
	}

}

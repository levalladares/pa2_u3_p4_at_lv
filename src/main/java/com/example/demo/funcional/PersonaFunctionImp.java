package com.example.demo.funcional;

public class PersonaFunctionImp implements IPersonaFunction<Integer, String>{

	@Override
	public Integer aplicar(String arg) {
		// TODO Auto-generated method stub
		if(arg.compareTo("Ahorros")==0) {
			return 1;
		}else {
			return 0;
		} 
	}
	

}

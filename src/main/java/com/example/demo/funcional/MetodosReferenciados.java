package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {
	private static final Logger LOG= LoggerFactory.getLogger(MetodosReferenciados.class);

	public static Integer getId(){
		return 8;
	}
	public static String getIdHO(){
		LOG.info("Metodos Referenciados y HO");
		return "Luis Valladares";
	}
	public static void acceptar(String arg) {
		String cadena="Luisssssssssssssssss";
		LOG.info(cadena+" "+arg);
	}
	public boolean evaluar(String arg) {
		if(arg.compareTo("Luis")==0) {
			return true;
		}else {
			return false;
		}
	}
	public Integer aplicar(String arg) {
		if(arg.compareTo("Ahorros")==0) {
			return 1;
		}else {
			return 0;
		} 
	}
	public Integer aplicar(Integer arg) {
		Integer nuevo;
		nuevo=arg+100;
		return nuevo;
	}
}

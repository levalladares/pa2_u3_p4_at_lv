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
	
	//>>>>>>>>> METODOS REFERENCIADOS TAREA 16 <<<<<<<<<<<<<
	//SUPPLIER
	public static String A() {
		return "Ejemplo 1";
		//LOG.info("Ejemplo 1:"+arg);
	}
	//CONSUMER
	//metodo que devuelve las palabras en mayusculas
	public static void B(String arg) {
		LOG.info("Ejemplo 2:"+arg.toUpperCase());
	}
	//PREDICATE
	//metodo que devuelve solo la palabras que comienzan con mayusculas
	public static boolean C (String arg) {
		char primerCaracter = arg.charAt(0);
		if(Character.isUpperCase(primerCaracter)) {
			LOG.info("Ejemplo 3:"+arg);
			return true;
		}
		return false;
	}
	//FUNCTION
	//metodo que devuelve el primer caracter de cada palabra
	public static Character D(String arg) {
		Character caracter=arg.charAt(0);
		LOG.info("Ejemplo 4:"+caracter);
		return caracter;
	}
	//UnaryOperator
	//metodo que devuelve solo los numeros pares 
	public static Integer E(Integer arg) {
		Integer par=null;
		if(arg%2 ==0) {
			par = arg;
			LOG.info("ejemplo 5:"+ par);
		}
		return par;
	}
	
	
	
}


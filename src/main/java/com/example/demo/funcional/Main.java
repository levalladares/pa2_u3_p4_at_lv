package com.example.demo.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger LOG= LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//PREDICATE
		//1.clase
		MetodosHighOrder.metodo3(new PersonaPredicateImpl(),"Luis");
		//2.Lambdas
		MetodosHighOrder.metodo3(cadena -> {
			char primerCaracter = cadena.charAt(0);
			if(Character.isUpperCase(primerCaracter)) {
				LOG.info(cadena);
				return true;
			}
			return false;
		},"Luis");
		//3. metodos referenciados
		MetodosHighOrder.metodo3(MetodosReferenciados::evaluar,"Luis");
		
		//FUNCTION
		//1.Clase
		MetodosHighOrder.metodo4(new PersonaFunctionImp(),"Ahorros");
		//2.Lambdas
		MetodosHighOrder.metodo4(cadena -> {if(cadena.compareTo("Ahorros")==0) {
			return 1;
		}else {
			return 0;
		} 
			
		},"Ahorros");
		//3. metodos referenciados
		MetodosHighOrder.metodo4(MetodosReferenciados::aplicar, "Ahorros");;
		
		
		//Unary Operator
		//1. clases
		MetodosHighOrder.metodo5(new PersonaUnaryImpl(), 50);
		//2.Lambda
		MetodosHighOrder.metodo5(numero -> numero+100, 50);
		//3. metodos referenciados
		MetodosHighOrder.metodo5(MetodosReferenciados::aplicar,50);
	
	}
}

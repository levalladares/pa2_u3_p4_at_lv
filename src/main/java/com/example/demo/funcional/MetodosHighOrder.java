package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder {
	private static final Logger LOG= LoggerFactory.getLogger(MetodosHighOrder.class);

	public static void metodo(IPersonaSupplier<String> funcion) {
		LOG.info("High Order Supplier"+funcion.getId());
	}
	
	public static void metodo2(IPersonaConsumer<String> funcion2,String cadena ) {
		LOG.info("Consumer High Order:" );
		funcion2.accept(cadena);
	}
	
	public static void metodo3(IPersonaPredicate<String> funcion3,String cadena ) {
		LOG.info("Predicate High Order:"+funcion3.evaluar(cadena) );
		
	}
	public static void metodo4(IPersonaFunction<Integer, String> funcion4,String cadena ) {
		LOG.info("Function High Order:"+ funcion4.aplicar(cadena) );
		
	}
	public static void metodo5(IPersonaUnary<Integer> funcion5,Integer numero ) {
		LOG.info("Unary Operator High Order:" + funcion5.aplicar(numero) );
		
	}
	
	
}

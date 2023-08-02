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
}

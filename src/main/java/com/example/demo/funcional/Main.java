package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger LOG= LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona per = new PersonaImpl();
		per.caminar();
		
		//1.- SUPPLIER
		//Clases:
		IPersonaSupplier<String> supplier1= new PersonaSupplierImpl();
		//buena practica para imprimir es un loger (slf4j)
		LOG.info("Supplier clase:"+supplier1.getId() );
		//Lambdas:
		IPersonaSupplier<String> supplier2 = () ->  "17239737966";
		LOG.info("Supplier lambda:"+supplier2.getId() );
		//EJEMPLO2
		IPersonaSupplier<String> supplier3 = () ->  {
			String cedula="17239737966";
			cedula= cedula+"zzzzzzzzzz";
			return cedula;
		};
		LOG.info("Supplier lambda 2:"+supplier3.getId() );
		//METODOS REFERENCIADOS
		MetodosReferenciados metodos= new MetodosReferenciados();
		IPersonaSupplier<Integer> supplier4=metodos::getId;  //--> dos puntos se conoce como metodos referenciados
		LOG.info("Supplier metodoReferenciado:"+supplier4.getId() );
		
		
		
		
		//2.- CONSUMER
		//Clase
		IPersonaConsumer<String> consumer1= new PersonaConsumerImpl();
		LOG.info("Consumer clase:" );
		consumer1.accept("Luis Valladares");
		//Lambda
		IPersonaConsumer<String> consumer2= cadena->{
			LOG.info("HOLA");
			LOG.info(cadena);
			LOG.info("CHAO");
			};
		LOG.info("Consumer LABMDA:" );
		consumer2.accept("Luis Valladares2");
		//metodos referenciados
		IPersonaConsumer<String> consumer3 = metodos::acceptar;
		LOG.info("Consumer metodos referenciados:" );
		consumer3.accept("A");
		
		
		
		
		//3.-PREDICATE
		//Lambda
		//ejemplo1
		IPersonaPredicate<Integer> predicate1 = valor -> valor.compareTo(8)==0;
		LOG.info("Predicate lambda:"+predicate1.evaluar(4) );
		// ejemplo2
		IPersonaPredicate<Integer> predicate2 = valor -> {
			Integer valor2=10;
			valor=valor+valor2;
			if(valor.compareTo(100)>0) {
				return true;
			}else {
				return false;
			}
		};
		LOG.info("Predicate lambda:"+predicate2.evaluar(95));
		//ejemplo3
		IPersonaPredicate<String> predicate3 = letra ->"Luis".contains(letra);
		LOG.info("Predicate ejemplo lambda:"+predicate3.evaluar("z") );
		//ejemplo14
		IPersonaBiPredicate<String,String> predicate4 = (letra,cadena) ->cadena.contains(letra); 
		LOG.info("Predicate lambda4:"+predicate4.evaluar("z","Luis") );
		//metodos referenciales
		IPersonaPredicate<String> predicate5 = metodos::evaluar;
		LOG.info("predicate metodoReferenciado:"+predicate5.evaluar("Jose") );
		
		
		
		//4.-FUNCTION
		//ejemplo1
		IPersonaFunction<String, Integer> function= numero ->numero.toString();
		LOG.info("FUNCTION lambda:"+function.aplicar(8) );
		//ejemplo2
		IPersonaFunction<String, Integer> function2= numero ->{
			String valorFinal = numero.toString().concat(" valor");
			return valorFinal;
		};
		LOG.info("FUNCTION lambda2:"+function2.aplicar(10) );
		//metodos referenciados
		IPersonaFunction<Integer, String >  function3 = metodos::aplicar;
		LOG.info("predicate metodoReferenciado:"+function3.aplicar("Ahorros") );
		
		
		//5.-UnaryOperator
		IPersonaUnary<Integer> unary=numero -> numero+(numero*2);
		LOG.info("UNARY lambda:"+unary.aplicar(3) );
		//CON EL FUNCTION
		IPersonaUnaryFunction<Integer> unary2=numero -> numero+(numero*2);
		LOG.info("UNARY lambda2:"+unary2.aplicar(3) );
		//metodos referenciados 
		IPersonaUnary<Integer>  unary3 = metodos:: aplicar;
		LOG.info("UNARI METODOS REFERENCIADOS:"+ unary3.aplicar(5));
		
	}


}

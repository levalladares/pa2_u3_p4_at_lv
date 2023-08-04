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
		
		//>>>>>>>>>>>>>>>>DEBER<<<<<<<<<<<<<<<<<<<
		//1.Supplier
		Stream<String> listaA=Stream.generate(MetodosReferenciados::A).limit(5);
		listaA.forEach(cadena-> LOG.info(cadena));
		//2.Consumer
		List<String> listaB= Arrays.asList("Jose","Andrea","Flavio","Jose","Csrlos");
		listaB.forEach(MetodosReferenciados::B);
		//3.Predicate
		List<String> listaC= Arrays.asList("Luis ernesto Valladares bastidas".split(" "));
		listaC.forEach(MetodosReferenciados::C);
		//4. Function
		listaC.forEach(MetodosReferenciados::D);
		//5.UnaryOperator
		List<Integer>listaD=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		listaD.forEach(MetodosReferenciados::E);

		
		
	
	}


}

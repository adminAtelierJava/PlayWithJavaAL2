package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;

import java.util.*;
import java.util.stream.Collectors;

import edu.esprit.game.utils.Data;


public class Level3 {
	public static void main(String[] args) {
	List<Employee> employees = Data.employees();
		

	/* TO DO 1: Retourner une chaine de caract�re qui contient tous les noms des employ�s */	
	String names = employees.stream().map(e->e.getName()).
			reduce("",(a,b)->a+" "+b);
			/* TO DO 1  hint(reduce)*/;
		System.out.println(names);
	/* TO DO 2: Retourner une chaine de caract�re qui contient tous les noms des employ�s en majuscule separ�s par # */	
	String namesMajSplit = employees.stream().map(e->e.getName().toUpperCase()).
			reduce("#",(a,b)->a+"#"+b);
			/* TO DO 2 */;
		System.out.println(namesMajSplit);

int sal=employees.stream().map(e->e.getSalary()).
		reduce(0,(som,emp)->som+emp);
		System.out.println(sal);
long sum = employees.stream().mapToInt(e->e.getSalary()).sum();
		System.out.println(sum);

		Set<Employee> set=employees.stream().collect(Collectors.toSet());

		TreeSet<Employee> tre=employees.stream().
				collect(Collectors.toCollection(()->new TreeSet<>(Comparator.comparing(Employee::getName))));
		Map<Integer,List<Employee>> lis=employees.stream().
				collect(Collectors.groupingBy(e->e.getSalary()));

	Map<Integer,String> map=employees.stream().
			collect(Collectors.toMap(e->e.getSalary(),e->e.getName(),(a,b)->a+b));

	map.entrySet().forEach(e->{
		System.out.println(e.getKey());
		System.out.println(e.getValue());
	});

	map.forEach((e,v)-> System.out.println(e + "" +v));


	String stt=employees.stream().mapToDouble(e->e.getSalary()).
			summaryStatistics().toString();

		System.out.println(stt);
	}
}

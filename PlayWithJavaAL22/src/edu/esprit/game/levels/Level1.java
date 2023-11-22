package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;
import edu.esprit.game.utils.Data;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Level1 {
	public static void main(String[] args) {
		List<Employee> employees = Data.employees();

		/* TO DO 1: Afficher tous les employ�s */
		employees.stream().forEach((Employee e)->{System.out.println(e);});
		employees.stream().forEach(e->System.out.println(e));


		employees.forEach(e-> System.out.println(e));


		/*
		 * TO DO 2: Afficher les employ�s dont le nom commence par la lettre n
		 */
		Stream<Employee> str=	employees.stream().
				filter(e->e.getName().startsWith("n"));
		employees.stream().filter(e->e.getName().startsWith("n")).
				forEach(e-> System.out.println(e));

		/*
		 * TO DO 3: Afficher les employ�s dont le nom commence par la lettre n
		 * et le salaire> 1000
		 */
		employees.stream().filter(e->e.getName().startsWith("n")).
				filter(e->e.getSalary()>1000)
				.forEach(e-> System.out.println(e));

		employees.stream().filter(e->e.getName().startsWith("n")&&e.getSalary()>1000)

				.forEach(e-> System.out.println(e));

		/*
		 * TO DO 4: Afficher les employ�s dont le nom commence par la lettre s
		 * tri�s par salaire
		 */
		employees.stream().
				filter(e->e.getName().startsWith("n")).
				//sorted(Comparator.comparing(Employee::getSalary)).
				sorted((Employee e1,Employee e2)->e1.getSalary().compareTo(e2.getSalary())).
				forEach(e-> System.out.println(e));


		/*
		 * TO DO 5: Afficher les noms des employ�s dont le salaire > 600 avec 2
		 * mani�res diff�rentes
		 */
		/* First Way */
		employees.stream().filter(e->e.getSalary()>600).
				forEach(e-> System.out.println(e.getName()));
		/* Second Way */
		Stream<String> strr=employees.stream().
				filter(e->e.getSalary()>600).map(EM->EM.getName());


		employees.stream().
				filter(e->e.getSalary()>600).map(EM->EM.getName())
				.forEach(emm-> System.out.println(emm));

		/*
		 * TO DO 6: Ajouter 200 D pour les employ�s dont le nom commence avec m
		 * et les affich�s ensuite
		 */
		employees.stream().filter(e->e.getName().startsWith("m")).
				forEach(e->{
					e.setSalary(e.getSalary()+200);
					System.out.println(e);
				});

	}
}

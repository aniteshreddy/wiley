package wiley.internship.com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FilterUsers {

    public static void main(String[] args) {

        List<Users> users = new ArrayList();
        String com = "wipro";
        users.add(new Employee(1, "Anitesh", new Addres("Hyderabad", "503001"), new Project(1, com, 1000.0), 700));
        users.add(new Users(2, "venkat"));
        users.add(new Employee(1, "Nikhil", new Addres("Adilabad", "503021"), new Project(1, com, 1000.0), 700));
        users.add(new Employee(1, "Tanu", new Addres("Nellore", "503041"), new Project(1, com, 1000.0), 300));
        users.add(new Employee(1, "Lekhya", new Addres("Vijayawada", "503071"), new Project(1, com, 1000.0), 100));

        List<Employee> emp1 = new ArrayList();
        List<Employee> emp = new ArrayList();


        double budget = 0;
        double overAll = 0;
        emp1 = users.stream().map(i-> i!=Users.class).collect(Collectors.toList());

        for (Users a : users) {
            if (a.getClass() != Users.class) {
                Employee b = (Employee) a;
                emp.add(b);
                budget = b.p.budget;
                overAll += b.salary;

            }

        }



        

        double[] sal = new double[emp.size()];

        if (budget < overAll) {
            for (int i = 0; i < emp.size(); i++) {
                sal[i] = overAll - emp.get(i).salary;

            }
        }
        

        else {
            System.out.println("Budget is sufficient for the people");
        }

    }

}

class Users {
    public int id;
    public String name;

    public Users(int id, String name) {
        this.id = id;
        this.name = name;
    }

}

class Employee extends Users {
    Addres a;
    Project p;
    double salary;

    public Employee(int id, String name, Addres a, Project p, double salary) {
        super(id, name);
        this.p = p;
        this.a = a;
        this.salary = salary;
    }

    double getdata() {
        return salary;
    }
}

class Addres {
    String city;
    String zipCode;

    public Addres(String city, String zipCode) {
        this.city = city;
        this.zipCode = zipCode;
    }
}

class Project {
    int projectId;
    String name;
    Double budget;

    public Project(int projectId, String name, Double budget) {
        this.projectId = projectId;
        this.name = name;
        this.budget = budget;
    }
}
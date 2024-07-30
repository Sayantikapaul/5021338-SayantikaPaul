import java.util.*;

class Employee {
    public int employeeId;
    public String name;
    public String position;
    public int salary;
    Employee(){}  //constructor over-riding
    Employee(int employeeId, String name, String position, int salary){
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}

class EmployeeSystem {

    public Employee employees[];
    public int current_index;
    private int CAPACITY;

    EmployeeSystem(int capacity){
        employees = new Employee[capacity];
        current_index = -1;
        this.CAPACITY = capacity;

        for(int i = 0; i < capacity; i++){
            employees[i] = new Employee();
        }
    }

    public void addEmployee(int employeeId, String name, String position, int salary){

        if(current_index >= CAPACITY){
            System.out.println("OVERFLOw");
        }else{
            current_index += 1;
            employees[current_index] = new Employee(employeeId, name, position, salary);


            System.out.println("Employee added!");
        }
    }

    public int searchEmployee(int id){
        for(int i = 0; i <= current_index; i++){
            Employee employee = employees[i];
            if(employee.employeeId == id){
                System.out.println("Employe Found!");
                System.out.println("Employe Id : "+employee.employeeId);
                System.out.println("Employe Name : "+employee.name);
                System.out.println("Employe position : "+employee.position);
                System.out.println("Employe Salary : "+employee.salary);
                return i;
            }
        }
        System.out.println("Employee Not Found!");
        return -1;
    }

    public void traverse(){
        if(current_index == -1){
            System.out.println("Can not Display Employee Not found");
        }else{
            for(int i = 0; i <= current_index; i++){
                Employee employee = employees[i];
                System.out.println("Employe Id : "+employee.employeeId);
                System.out.println("Employe Name : "+employee.name);
                System.out.println("Employe position : "+employee.position);
                System.out.println("Employe Salary : "+employee.salary);
                System.out.println();   
            }
        }
    }

    public void delete(int id){

        if(current_index == -1){
            System.out.println("Can't Delete Employee!");
        }else{
            int res = searchEmployee(id);
            int i;
            if(res != -1){
                for(i = res + 1; i < current_index; i++){
                    employees[i - 1] = employees[i];
                }
                employees[i] = new Employee(); // clear the last element
                current_index -= 1;
                System.out.println("Employee deleted succesfully");
            }else{
                System.out.println("Employee can't found");
            }
        }
    }

}


public class Main {
        public static void main(String[] args) {
            EmployeeSystem employeeSystem = new EmployeeSystem(5);
            while (true) {
                Scanner sc = new Scanner(System.in);
    
                System.out.println("EMPLOYEE MANAGEMENT SYSTEM");
                System.out.println("1. Add ");
                System.out.println("2. Delete ");
                System.out.println("3. Search ");
                System.out.println("4. Traverse ");
                System.out.println("5. Exit");
    
                System.out.println("Enter choice : ");
                int ch = sc.nextInt();
    
                switch (ch) {
                    case 1:
                        System.out.println("Enter Employee Id: ");
                        int employeeId = sc.nextInt();
                        sc.nextLine(); // Consume the newline character

                        System.out.println("Enter Employee Name: ");
                        String name = sc.nextLine();


                        System.out.println("Enter Employee Position: ");
                        String position = sc.nextLine();

                        System.out.println("Enter Employee Salary: ");
                        int salary = sc.nextInt();
                        employeeSystem.addEmployee(employeeId, name, position, salary);
                        break;
    
                    case 2:
                        System.out.println("Enter Employee Id : ");
                        employeeId = sc.nextInt();
                        employeeSystem.delete(employeeId);                        
                        break;
    
                    case 3:
                        System.out.println("Enter Employee Id : ");
                        employeeId = sc.nextInt();
                        employeeSystem.searchEmployee(employeeId);
                        break;
    
                    case 4:
                        employeeSystem.traverse();
                        break;
    
                    case 5:
                        System.exit(0);
    
                    default:
                        System.out.println("OOPS! WRONG CHOICE !");
                }
            }
        }
}

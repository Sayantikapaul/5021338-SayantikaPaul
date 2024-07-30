import java.util.*;

class Task {
    public int taskId;
    public String taskName;
    public String status;
    Task(){}
    Task(int taskId, String taskName, String status){
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }
}

//Linkedlist
class Node {
    Task task;
    Node next;
    Node(){}
    Node( Task task ){
        this.task = task;
        this.next = null;
    }
}

class MyLinkedList {
    private Node head;
    private Node curr;
    MyLinkedList(){
        this.head = null;
        this.curr = null;
    }

    public void addTask(int taskId, String taskName, String status){
        Task task = new Task(taskId, taskName, status);
        Node newNode = new Node(task);
        if(head == null){
            head = newNode;
            curr = newNode;
        }else{

            curr.next = newNode;
            curr = newNode;
        }
        System.out.println("Task Added Succesfully");
    }

    public void serach(int taskId){
        if(head == null){
            System.out.println("Task could not found");
        }else{
            Node ptr = head;
            while (ptr != null) {
                Task task = ptr.task;
                if(task.taskId == taskId){
                    System.out.println("Task Found!");
                    System.out.println("Task Id : "+task.taskId);
                    System.out.println("Task Name : "+task.taskName);
                    System.out.println("Task Status : "+task.status);
                    return;
                }
                ptr = ptr.next;
            }
            System.out.println("Task not found!");
        }
    }

    public void delete(int taskId){
        if(head == null){
            System.out.println("No Task found");
        }else{
            Node ptr = head;
            Node prev = null;
            if(head.task.taskId == taskId){
                head = head.next;
                System.out.println("Task Deleted Sucessfully");
                return;
            }
            while (ptr != null) {
                Task task = ptr.task;
                if(task.taskId == taskId){
                    prev.next = ptr.next;
                    ptr.next = null;
                    System.out.println("Task Deleted Sucessfully");
                    return;
                }
                prev = ptr;
                ptr = ptr.next;
            }

            System.out.println("Task not found!");
        }
    }

    public void display(){
        Node ptr = head;
        while(ptr != null){
            Task task = ptr.task;
            System.out.println("Task Id : "+task.taskId);
            System.out.println("Task Name : "+task.taskName);
            System.out.println("Task Status : "+task.status);
            System.out.println();
            ptr = ptr.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyLinkedList LL = new MyLinkedList();

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("TASK MANAGEMENT SYSTEM");
            System.out.println("1. Add ");
            System.out.println("2. Delete ");
            System.out.println("3. Search ");
            System.out.println("4. Traverse ");
            System.out.println("5. Exit");

            System.out.println("Enter choice : ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter Task Id: ");
                    int taskId = sc.nextInt();
                    sc.nextLine(); // Consume the newline character
                    System.out.println("Enter Task Name: ");
                    String taskName = sc.nextLine();
                    System.out.println("Enter Task Status: ");
                    String status = sc.nextLine();
                    LL.addTask(taskId, taskName, status);
                    break;

                case 2:
                    System.out.println("Enter Task Id : ");
                    taskId = sc.nextInt();
                    LL.delete(taskId);
                    break;

                case 3:
                    System.out.println("Enter Task Id : ");
                    taskId = sc.nextInt();
                    LL.serach(taskId);
                    break;

                case 4:
                    LL.display();
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("OOPS! WRONG CHOICE !");
            }
        }
    }
}
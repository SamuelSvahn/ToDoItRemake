package se.lexicon.View;

import se.lexicon.model.*;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Scanner;

public class ConsoleUI {



    public MenuActions displayMenu(){
        System.out.println("Welcome to this Application");
        System.out.println("Choose one operation");

        System.out.println("1. Create User.");
        System.out.println("2. Create task.");
        System.out.println("3. Display users.");
        System.out.println("4. Display tasks.");
        System.out.println("5. Exit the application.");

        System.out.println("Write your choice: ");
        int command = getNumber();
        switch (command){
            case 1:
                return MenuActions.CREATE_USER;
            case 2:
                return MenuActions.CREATE_TASK;
            case 3:
                return MenuActions.DISPLAY_USERS;
            case 4:
                return MenuActions.DISPLAY_TASKS;
            case 5:
                return MenuActions.EXIT;
        }

    }

    public int getNumber(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String getString (){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    public Person getPersonInformation(){
        System.out.println("Pick Username: ");
        String username = getString();

        System.out.println("Pick password: ");
        String password = getString();

        AppUser appUser = new AppUser(username,password, AppRole.ROLE_APP_USER);

        System.out.println("Write your First Name: ");
        String firstName = getString();

        System.out.println("Write your Last Name: ");
        String lastName = getString();

        Person person = new Person(firstName,lastName,appUser);

        return person;


    }
    public void displayPersonInformation(Person person){
        System.out.println(person.toString());


    }
    public ToDoItemTask getTodoItemData(){
        System.out.println("Title of Task: ");
        String title = getString();

        System.out.println("Description of the Task: ");
        String description = getString();

        System.out.println("Deadline for the Task (YYYY-MM-DD): ");
        String deadline= getString();

        System.out.println("Person ID: ");
        int personId = getNumber();

        ToDoItem toDoItemInformation = new ToDoItem(title,description, LocalDate.parse(deadline));


        Person personInfo = new Person();
        personInfo.setId(personId);
        ToDoItemTask toDoItemTask = new ToDoItemTask(toDoItemInformation,personInfo);


        return toDoItemTask;

        }



    public void displayToDoInformation(ToDoItemTask toDoItemTask){
        System.out.println(toDoItemTask.toString());

    }
    public void displayToDoInformation(Collection<ToDoItemTask> toDoItemTasks){
        for(ToDoItemTask toDoItemTask: toDoItemTasks ){
            System.out.println(toDoItemTask);
        }

    }

    public void displayUsers(Person person){
        System.out.println(person.toString());


    }

    public void displayUsers(Collection<Person> persons){
        for(Person person: persons){
            System.out.println(person);
        }

    }

}

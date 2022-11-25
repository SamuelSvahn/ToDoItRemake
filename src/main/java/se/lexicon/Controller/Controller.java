package se.lexicon.Controller;

import se.lexicon.Dao.AppUserDao;
import se.lexicon.Dao.Implementations.AppUserDAOImpl;
import se.lexicon.Dao.Implementations.PersonDAOImpl;
import se.lexicon.Dao.Implementations.ToDoItemDAOImpl;
import se.lexicon.Dao.Implementations.ToDoItemTaskDAOImpl;
import se.lexicon.Dao.PersonDAO;
import se.lexicon.Dao.ToDoItemDAO;
import se.lexicon.Dao.ToDoItemTaskDAO;
import se.lexicon.View.ConsoleUI;
import se.lexicon.View.MenuActions;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;
import se.lexicon.model.ToDoItem;
import se.lexicon.model.ToDoItemTask;

import java.util.Collection;

public class Controller {

    //Implementations
    ConsoleUI ui;
    PersonDAO personDAO;
    ToDoItemDAO toDoItemDAO;
    ToDoItemTaskDAO toDoItemTaskDAO;
    AppUserDao appUserDao;


    public Controller() {
        ui = new ConsoleUI();
        personDAO = PersonDAOImpl.getInstance();
        toDoItemDAO = ToDoItemDAOImpl.getInstance();
        toDoItemTaskDAO = ToDoItemTaskDAOImpl.getInstance();
        appUserDao = AppUserDAOImpl.getInstance();

    }

    public void doMainMenu() {

        while (true) {
            MenuActions commands = ui.displayMenu();
            switch (commands) {
                case REGISTER:
                    startRegister();
                    break;
                case CREATE_TASK:
                    startCreatingTask();
                    break;
                case DISPLAY_USERS:
                    startDisplayUsers();
                    break;
                case DISPLAY_TASKS:
                    startDisplayTasks();
                    break;
                case EXIT:
                    System.exit(0);
            }
        }

    }

    public void startRegister() {
        Person personInformation = ui.getPersonInformation();

        AppUser appUser = personInformation.credentials;
        AppUser createdUser = appUserDao.add(appUser);

        personInformation.setCredentials(createdUser);
        Person createdPerson = personDAO.add(personInformation);

        ui.displayPersonInformation(createdPerson);

    }

    public void startCreatingTask() {
        ToDoItemTask toDoItemTaskData = ui.getTodoItemData();
        Person person = toDoItemTaskData.getAssignee();

        Person foundPerson = personDAO.findById(person.getId());

        toDoItemTaskData.setAssignee(foundPerson);
        ToDoItemTask createdToDoItem = toDoItemTaskDAO.add(toDoItemTaskData);

        ui.displayToDoInformation(createdToDoItem);


    }

    public void startDisplayTask(ToDoItemTask toDoItemTask) {
        ui.displayToDoInformation(toDoItemTask);
    }

    public void startDisplayTasks() {
        Collection<ToDoItemTask> toDoItemTaskList = toDoItemTaskDAO.findAll();
        ui.displayToDoInformation(toDoItemTaskList);

    }

    public void startDisplayPerson(Person person) {
        ui.displayUsers(person);
    }

    public void startDisplayUsers() {
        Collection<Person> personList = personDAO.findAll();
        ui.displayUsers(personList);

    }
}

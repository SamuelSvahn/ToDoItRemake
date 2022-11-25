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

public class Controller {

    //Implementations
    ConsoleUI ui;
    PersonDAO personDAO;
    ToDoItemDAO toDoItemDAO;
    ToDoItemTaskDAO toDoItemTaskDAO;
    AppUserDao appUserDao;


    public Controller(){
    ui = new ConsoleUI();
    personDAO = PersonDAOImpl.getInstance();
    toDoItemDAO = ToDoItemDAOImpl.getInstance();
    toDoItemTaskDAO= ToDoItemTaskDAOImpl.getInstance();
    appUserDao= AppUserDAOImpl.getInstance();

    }

    public void doMainMenu(){

        while(true){
            MenuActions commands = ui.displayMenu();
                switch (commands){
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

    public void startRegister(){

    }

    public void startCreatingTask(){

    }

    public void startDisplayTasks(){

    }

    public void startDisplayUsers(){

    }
}

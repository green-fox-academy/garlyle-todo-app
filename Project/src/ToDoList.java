import java.util.ArrayList;

public class ToDoList {
  private ArrayList<ToDo> listOfTasks;

  public ToDoList()
  {
    listOfTasks = new ArrayList<>();
  }

  public void printTasks() {
    if (listOfTasks.size() == 0)
    {
      System.out.println("No todos for today! :)");
    }
  }
}

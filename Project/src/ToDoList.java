import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    } else {
      for (int i = 0; i < listOfTasks.size(); i++) {
        System.out.println((i + 1) + " - " + listOfTasks.get(i).getTask());
      }
    }
  }

  public void loadTasks() {
    Path filePath = Paths.get("tasks");

    try {
      for (String line : Files.readAllLines(filePath)) {
        if (!line.startsWith(ToDo.UNDONE) && !line.startsWith(ToDo.DONE)) {
          addTask(ToDo.UNDONE + line);
        } else {
          addTask(line);
        }
      }
    } catch (Exception ex) {
    }
  }

  public void saveTasks() {
    Path filePath = Paths.get("tasks");
    try {
      if (!Files.exists(filePath)) {
        Files.createFile(filePath);
      }
      ArrayList<String> out = new ArrayList<>();
      for (ToDo task : listOfTasks) {
        out.add(task.getTask());
      }
      Files.write(filePath, out);
    } catch (Exception ex) {
    }
  }

  public void addTask(String task) {
    listOfTasks.add(new ToDo(task));
  }

  public void removeTask(int index) {
    listOfTasks.remove(index);
  }

  public void checkTask(int i) {
    listOfTasks.get(i).check();
  }
}

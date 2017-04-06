public class App {
  public static void main(String[] args) {
    if (args.length == 0) {
      printUsage();
    } else {
      ToDoList todoList = new ToDoList();
      todoList.loadTasks();
      if (args[0].equals("-l"))
      {
        todoList.printTasks();
      }
    }
  }

  private static void printUsage() {
    System.out.println("Java Todo application");
    System.out.println("=====================");
    System.out.println();
    System.out.println("Command line arguments:");
    System.out.println(" -l   Lists all the tasks");
    System.out.println(" -a   Adds a new task");
    System.out.println(" -r   Removes an task");
    System.out.println(" -c   Completes an task");
  }
}

public class App {
  ToDoList todoList;

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Java Todo application");
      System.out.println("=====================");
      System.out.println();
      printUsage();
    } else {
      ToDoList todoList = new ToDoList();
      todoList.loadTasks();
      if (args[0].equals("-l"))
      {
        todoList.printTasks();
      } else if (args[0].equals("-a")) {
        if (args.length < 2) {
          System.out.println("Unable to add: no task provided");
        } else {
          todoList.addTask(ToDo.UNDONE + args[1]);
          todoList.saveTasks();
        }
      } else if (args[0].equals("-r")) {
        todoList.removeTask(Integer.parseInt(args[1]) - 1);
        todoList.saveTasks();
      } else if (args[0].equals("-c")) {
        todoList.checkTask(Integer.parseInt(args[1]) - 1);
        todoList.saveTasks();
      } else {
        System.out.println("Error: Unsupported argument");
        printUsage();
      }
    }
  }

  private static void printUsage() {
    System.out.println("Command line arguments:");
    System.out.println(" -l   Lists all the tasks");
    System.out.println(" -a   Adds a new task");
    System.out.println(" -r   Removes an task");
    System.out.println(" -c   Completes an task");
  }
}

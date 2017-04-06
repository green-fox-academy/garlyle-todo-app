public class App {
  static ToDoList todoList;

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Java Todo application");
      System.out.println("=====================");
      System.out.println();
      printUsage();
    } else {
      todoList = new ToDoList();
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
        if (checkForNumericArguments(args, todoList, "Unable to remove: ")) {
          todoList.removeTask(Integer.parseInt(args[1]) - 1);
          todoList.saveTasks();
        }
      } else if (args[0].equals("-c")) {
        if (checkForNumericArguments(args, todoList, "Unable to check: ")) {
          todoList.checkTask(Integer.parseInt(args[1]) - 1);
          todoList.saveTasks();
        }
      } else {
        System.out.println("Error: Unsupported argument");
        printUsage();
      }
    }
  }

  private static boolean checkForNumericArguments(String[] args, ToDoList list, String err) {
    if (args.length < 2) {
      System.out.println(err + "no index provided");
    } else if (!args[1].matches(".*\\d+.*" )){
      System.out.println(err + "index is not a number");
    } else if (!list.isIndexValid(Integer.parseInt(args[1]))) {
      System.out.println(err + "index is out of bound");
    } else {
      return true;
    }
    return false;
  }

  private static void printUsage() {
    System.out.println("Command line arguments:");
    System.out.println(" -l   Lists all the tasks");
    System.out.println(" -a   Adds a new task");
    System.out.println(" -r   Removes an task");
    System.out.println(" -c   Completes an task");
  }
}

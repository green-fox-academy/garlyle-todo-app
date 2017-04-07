public class App {
  static ToDoList todoList;

  public static void main(String[] args) {
    if (args.length == 0) {
      printInformation();
    } else {
      todoList = new ToDoList();
      handleArguments(args);
    }
  }

  private static void handleArguments(String[] args) {
    if (args[0].equals("-l")) {
      todoList.printTasks();
    } else {
      try {
        if (args[0].equals("-a")) {
          todoList.addTask(ToDo.UNDONE + args[1]);
        } else if (args[0].equals("-r")) {
            todoList.removeTask(Integer.parseInt(args[1]) - 1);
        } else if (args[0].equals("-c")) {
            todoList.checkTask(Integer.parseInt(args[1]) - 1);
        } else {
          System.out.println("Error: Unsupported argument");
          printUsage();
          return;
        }
        todoList.saveTasks();
      } catch (Exception ex) {
        String err = "Unable to ";
        err += ((args[0].equals("-a"))? "add" :
               (args[0].equals("-r"))? "remove" :
               (args[0].equals("-c"))? "check" :
               "") + ": ";
        err += (ex instanceof ArrayIndexOutOfBoundsException)?
                  ((args[0].equals("-a"))? "no task provided" : "no index provided") :
               (ex instanceof IndexOutOfBoundsException)? "index is out of bound" :
               (ex instanceof NumberFormatException)? "index is not a number" :
               "";
        System.out.println(err);
      }
    }
  }

  private static void printInformation() {
    System.out.println("Java Todo application");
    System.out.println("=====================");
    System.out.println();
    printUsage();
  }

  private static void printUsage() {
    System.out.println("Command line arguments:");
    System.out.println(" -l   Lists all the tasks");
    System.out.println(" -a   Adds a new task");
    System.out.println(" -r   Removes an task");
    System.out.println(" -c   Completes an task");
  }
}

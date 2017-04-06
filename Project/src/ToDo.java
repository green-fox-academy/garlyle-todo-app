public class ToDo {
  private String taskDescription;
  final static String DONE = "[x] ";
  final static String UNDONE = "[ ] ";

  public ToDo(String description) {
    setTask(description);
  }

  public String getTask() {
    return taskDescription;
  }

  public void setTask(String description) {
    this.taskDescription = description;
  }

  public void check() {
    taskDescription = DONE + taskDescription.substring(UNDONE.length());
  }
}

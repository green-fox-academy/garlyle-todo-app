public class ToDo {
  private String taskDescription;

  public ToDo(String description) {
    taskDescription = description;
  }

  public String getTask() {
    return taskDescription;
  }

  public void setTask(String description) {
    this.taskDescription = taskDescription;
  }
}

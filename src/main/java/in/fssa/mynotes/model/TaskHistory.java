package in.fssa.mynotes.model;

import java.time.LocalDateTime;

public class TaskHistory {
    private int id;
    private String action;
    private String taskName;
    private String taskDescription;
    private LocalDateTime createdAt;

    public TaskHistory() {
    }

    public TaskHistory(int id, String action, String taskName, String taskDescription, LocalDateTime createdAt) {
        this.id = id;
        this.action = action;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "TaskHistory [id=" + id + ", action=" + action + ", taskName=" + taskName
                + ", taskDescription=" + taskDescription + ", createdAt=" + createdAt + "]";
    }
}

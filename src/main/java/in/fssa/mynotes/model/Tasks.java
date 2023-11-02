package in.fssa.mynotes.model;

import java.time.LocalDateTime;

public class Tasks {
    private int id;
    private String name;
    private String description;
    private String status;
    private int createdBy; 
    private Priority priority; 
    private LocalDateTime dueDate;
    private boolean is_deleted;

    public Tasks() {
    }

    public Tasks(int id, String name, String description, String status, int createdBy, Priority priority, LocalDateTime dueDate, String duration , boolean is_deleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.priority = priority; 
        this.dueDate = dueDate;
        this.is_deleted = is_deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getPriority() {
        return priority.getValue();
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setPriority(String priority) {
        this.priority = Priority.fromValue(priority.toUpperCase());
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
    
    public boolean getIsDeleted() {
        return is_deleted;
    }

    public void getIsDeleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }
    
    
    @Override
    public String toString() {
        return "Tasks [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status
                + ", createdBy=" + createdBy + ", priority=" + priority + ", dueDate=" + dueDate + ", is_deleted=" + is_deleted + "]";
    }
	
}

	


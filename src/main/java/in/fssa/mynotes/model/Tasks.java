package in.fssa.mynotes.model;

import java.time.LocalDateTime;

public class Tasks {
    private int id;
    private String name;
    private String description;
    private String status;
    private int createdBy; // Assuming createdBy is an integer representing user ID
    private Priority priority; // Use the 'Priority' enum
    private LocalDateTime dueDate; // Added due date property
//    private String duration; // Combined duration in days and minutes as a string (e.g., "2 days 30 minutes")

    public Tasks() {
    }

    public Tasks(int id, String name, String description, String status, int createdBy, Priority priority, LocalDateTime dueDate, String duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.priority = priority; // Initialize the 'priority' property
        this.dueDate = dueDate; // Initialize the 'dueDate' property
//        this.duration = duration; // Initialize the 'duration' property
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

//    public String getDuration() {
//        return duration;
//    }
//
//    public void setDuration(String duration) {
//        this.duration = duration;
//    }

    // Calculate and set the duration based on the due date and current date
//    public void calculateDuration() {
//        if (dueDate != null) {
//            long timeDifferenceMillis = dueDate.getTime() - new Date().getTime();
//            long days = TimeUnit.MILLISECONDS.toDays(timeDifferenceMillis);
//            long minutes = TimeUnit.MILLISECONDS.toMinutes(timeDifferenceMillis) % 60;
//            this.duration = days + " days " + minutes + " minutes";
//        }
//    }

    @Override
    public String toString() {
        return "Tasks [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status
                + ", createdBy=" + createdBy + ", priority=" + priority + ", dueDate=" + dueDate + "]";
    }

	

	
}

	


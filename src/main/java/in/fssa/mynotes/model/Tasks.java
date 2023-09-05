package in.fssa.mynotes.model;

public class Tasks {
    private int id;
    private String name;
    private String description;
    private String status;
    private int createdBy; // Assuming createdBy is an integer representing user ID
    private int parentTask; // Assuming parentTask is an integer representing parent task ID

    public Tasks() {
    }

    public Tasks(int id, String name, String description, String status, int createdBy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
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

  

    @Override
    public String toString() {
        return "Tasks [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status
                + ", createdBy=" + createdBy + ", parentTask=" + parentTask + "]";
    }
}

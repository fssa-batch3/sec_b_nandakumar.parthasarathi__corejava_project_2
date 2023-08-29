package in.fssa.mynotes.model;

public class Tasks {
    private int id;
    private String name;
    private String description;
    private String status;
    private String parent_task;

    public Tasks() {
    }

    public Tasks(int id, String name, String description, String status, String parent_task) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.parent_task = parent_task;
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



    @Override
    public String toString() {
        return "Task [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status + "]";
    }

}

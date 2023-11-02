package in.fssa.mynotes.model;

public enum Priority {
    HIGH("High"), MEDIUM("Medium"), LOW("Low");

    private final String value;

    Priority(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Priority fromValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Priority value cannot be empty or null");
        }

        for (Priority priority : Priority.values()) {
            if (priority.value.equalsIgnoreCase(value.trim())) {
                return priority;
            }
        }
        
        throw new IllegalArgumentException("Invalid priority value: " + value);
    }
}

package in.fssa.mynotes.Interface;


import java.util.Set;
import in.fssa.mynotes.exception.PersistanceException;
import in.fssa.mynotes.model.Tasks;

public interface TasksInterface {

    Set<Tasks> findAll() throws PersistanceException;

    Tasks findById(int taskId) throws PersistanceException;

    void create(Tasks newTask) throws PersistanceException;

    void update(int id, Tasks updateTask) throws PersistanceException;

    void checkIdExists(int id) throws PersistanceException;
}
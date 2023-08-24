package in.fssa.mynotes.Interface;

import java.util.Set;

import in.fssa.mynotes.exception.PersistanceException;

public interface Base<T> {

	public abstract Set<T> findAll() throws PersistanceException;
	public abstract void create(T object) throws PersistanceException;
	public abstract void update(int id, T object) throws PersistanceException;
	public abstract T findById(int id) throws PersistanceException;
}
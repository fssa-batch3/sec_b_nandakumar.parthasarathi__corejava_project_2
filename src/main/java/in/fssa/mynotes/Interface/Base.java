package in.fssa.mynotes.Interface;

import in.fssa.mynotes.exception.PersistanceException;

public interface Base<T> {

	public abstract void create(T object) throws PersistanceException;
	public abstract void update(int id, T object) throws PersistanceException;
}



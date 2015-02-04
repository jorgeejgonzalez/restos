package org.idisoft.restos.factory;

import java.util.List;
import java.util.Set;

public interface ModelFactory<T> {
	
	public T createEntity();
	
	public T copyEntity(final T original); 
	
	public List<T> createList();
	
	public Set<T> createSet();

}

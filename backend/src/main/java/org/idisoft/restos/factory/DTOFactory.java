package org.idisoft.restos.factory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class DTOFactory<T> implements ModelFactory<T>{
	
	@Override
	public List<T> createList()
	{
		return new ArrayList<T>(0);
	}
	
	@Override
	public Set<T> createSet()
	{
		return new HashSet<T>(0);
	}

}

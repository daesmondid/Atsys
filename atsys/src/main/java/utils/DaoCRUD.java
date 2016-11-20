package utils;

import java.util.ArrayList;

public interface DaoCRUD {
	
	public void add(Object object);
	public void remove(int id);
	//public abstract void edit();
	public ArrayList list();
	public Object get(int id);

}

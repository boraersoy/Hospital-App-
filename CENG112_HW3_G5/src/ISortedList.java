import java.text.ParseException;

public interface ISortedList<T> {
	public T remove(int givenPosition);
	
	public boolean isEmpty();
	
	public Patient[] toArray();
	
	public int getNumberOfEntries();
	
	public void add(T newEntry) throws ParseException ;

}

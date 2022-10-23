import java.text.ParseException;

public interface IHospitalQueue<T> {
	public T getData();
		
	public void setData(T data);
	
	public void enqueue(T newEntry) throws ParseException;
	
	public boolean isEmpty();

	public T getFront();
	
	public T dequeue();
	
	public int getNumberOfEntries();
	
	public void runQueue();
	
	public void printQueue();
}

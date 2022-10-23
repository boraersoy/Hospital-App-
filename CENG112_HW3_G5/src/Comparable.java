import java.text.ParseException;

public interface Comparable<T> {
	public int compareTo(T other) throws ParseException;

}

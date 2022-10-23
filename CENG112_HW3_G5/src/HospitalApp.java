import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class HospitalApp {

	public static void main(String[] args) throws ParseException, IOException {
		String file = "records.txt";
		BufferedReader reader = null;
		String line = "";
		reader = new BufferedReader(new FileReader(file));
		ISortedList<Patient> hospitalList = new SortedList<Patient>();
		IHospitalQueue<Patient> HospitalQueue = new HospitalQueue<>();
		while((line = reader.readLine()) != null) {
			String[] row = line.split(",");
			Patient patient= new Patient(row[1],Integer.parseInt(row[2]), row[3], row[4], row[5], row[6], row[7]);
			hospitalList.add(patient);
			HospitalQueue.enqueue(patient);		
		}
		reader.close();
		System.out.println("LIST OF PATIENTS");
		for (int i = 0; i < hospitalList.getNumberOfEntries(); i++) {
		System.out.println(hospitalList.toArray()[i]);
		}
		System.out.println("HOSPITAL QUEUE");
		HospitalQueue.printQueue();
		System.out.println("RUNNING QUEUE");
		HospitalQueue.runQueue();	
	}
}

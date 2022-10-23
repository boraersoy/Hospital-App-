import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class Patient implements Comparable<Patient>{
	private String name_surname;
	private int age;
	private String gender;
	private String pregnancy;
	private String disability;
	private String date;
	private String time;
	private int Priority;
	
	public Patient(String name_surname, int age, String gender, String pregnancy, String disability, String date,
			String time) {
		super();
		this.name_surname = name_surname;
		this.age = age;
		this.gender = gender;
		this.pregnancy = pregnancy;
		this.disability = disability;
		this.date = date;
		this.time = time;
					
			if(this.disability.equals("disabled")) {
				Priority = 5;
			}
		else if(this.age > 65) {
				Priority = 4;
			}
			else if(this.age < 18) {
				Priority = 2;
			}
							
			else if(this.pregnancy.equals("preg")) {
				Priority = 3;
			}			
			else {
				Priority = 1;
			}
			}
	public int getPriority() {
		return Priority;
	}
	public void setPriority(int priority) {
		Priority = priority;
	}
	public Patient() {

			}
	public int compareTo(Patient other) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		LocalTime time1 = LocalTime.parse(time);
		LocalTime time2 = LocalTime.parse(other.time);
		Date date1 = sdf.parse(date);  
		Date date2 = sdf.parse(other.date);  
		if(date1.compareTo(date2) > 0) {
			return 1; //means after
		}
		if((date1.compareTo(date2) == 0) && time1.isAfter(time2) ) {
			return 1; //means after
		}
		if((date1.compareTo(date2) == 0) && time1.equals(time2) ) {
			return 0; //means equal
		}
		else {return -1; //means before
		}		
	}
	public int compareWithPriority(Patient other) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		LocalTime time1 = LocalTime.parse(time);
		LocalTime time2 = LocalTime.parse(other.time);
		//dates to  compare  
		Date date1 = sdf.parse(date);  
		Date date2 = sdf.parse(other.date);  
		if(date1.compareTo(date2) > 0) {
			return 1; //means after
		}
		else if((date1.compareTo(date2) == 0) && time1.isAfter(time2) && Priority == other.Priority ) {
			return 1; //means after
		}
		else if((date1.compareTo(date2) == 0) && time1.isBefore(time2) && Priority == other.Priority ) {
			return -1; //means equal
		}
		else if((date1.compareTo(date2) == 0) && Priority > other.Priority ) {
			return -1; //means equal
		}
		else if((date1.compareTo(date2) == 0) && Priority < other.Priority ) {
			return 1; //means equal
		}
		else {return -1; //means before
		}		
	}
	public String getName_surname() {
		return name_surname;
	}
	public void setName_surname(String name_surname) {
		this.name_surname = name_surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPregnancy() {
		return pregnancy;
	}
	public void setPregnancy(String pregnancy) {
		this.pregnancy = pregnancy;
	}
	public String getDisability() {
		return disability;
	}
	public void setDisability(String disability) {
		this.disability = disability;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Patient [name_surname=" + name_surname + ", age=" + age + ", gender=" + gender + ", pregnancy="
				+ pregnancy + ", disability=" + disability + ", date=" + date + ", time=" + time + ", Priority="
				+ Priority + "]";
	}
	
}

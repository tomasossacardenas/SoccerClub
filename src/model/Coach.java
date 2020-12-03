package model;
public abstract class Coach extends Employee{
	//atributes
	private int experienceYears;

	public Coach(String name, String identifier, int salary,int experienceYears){
		super(name,  identifier, salary);
		this.experienceYears=experienceYears;
	}
	public int getExperienceYears(){
		return experienceYears;
	}
/**
* This method shows the coach info. <br>
*<b>Pos:</b>The information has been shown correctly<br>
* @return message, String that shows the info of the coach.
*/
	public String showInfo(){
		String message;
		message=super.showInfo()+"\n**  Años de experiencia: "+getExperienceYears();

		return message;
	}
}
package model;

public class Assistant extends Coach{

	//atributes
	private boolean playerBefore;
	private Expertice[] expertices;

	public Assistant(String name, String identifier, int salary, int experienceYears, boolean playerBefore, Expertice[] expertices){
		super(name, identifier, salary, experienceYears);
		this.playerBefore=playerBefore;
		this.expertices=expertices;
	}
	public boolean getPlayerBefore(){
		return playerBefore;
	}
	public Expertice[] getExpertice(){
		return expertices;
	}
/**
* This method shows the assistant info. <br>
*<b>Pos:</b>The information has been shown correctly<br>
* @return message, String that shows the info of the assistant.
*/
	public String showInfo(){
		String message;
		String experticeNames="";
		for(int i=0;i<expertices.length;i++){
			experticeNames+=expertices[i].name()+" ";
		}
		message="********************* Asistente Tecnico ***********************"+
		super.showInfo()+
		"\n**  ¿Exjugador profesional?: "+getPlayerBefore()+
		"\n**  Especialidades "+experticeNames+
		"\n***************************************************";
		return message;
	}
}
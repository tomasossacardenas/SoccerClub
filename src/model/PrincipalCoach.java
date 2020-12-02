package model;
public class PrincipalCoach extends Coach implements Price{
	//atributes
	private int teamsInCharge;
	private int championshipsWon;
	private String[]championships;

	public PrincipalCoach(String name, String identifier, int salary, int experienceYears, int teamsInCharge, int championshipsWon, String[] championships){
		super(name, identifier, salary, experienceYears);
		this.teamsInCharge=teamsInCharge;
		this.championshipsWon=championshipsWon;
		this.championships=championships;
	}
	public int getTeamsInCharge(){
		return teamsInCharge;
	}
	public int getChampionshipWon(){
		return championshipsWon;
	}
	public String showInfo(){
		String message;
		String championshipsNames="";
		for(int i=0;i<championshipsWon;i++){
			championshipsNames+=championships[i]+" ";
		}
		message="********************* Entrenador Principal ***********************"+
		super.showInfo()+
		"\n**  Equipos que ha estado cargo: "+getTeamsInCharge()+
		"\n**  Campeonatos ganados: "+getChampionshipWon()+
		"\n**  Nombre de campeonatos ganados: "+championshipsNames+
		"\n**  Precio de mercado: "+calculateMarketPrice()+
		"\n**  Nivel de estrellas: "+calculateStarLevel()+
		"\n***************************************************";

		return message;
	}
	public double calculateMarketPrice(){
		double marketPrice;
		marketPrice=(getSalary()*10)+(getExperienceYears()*100)+(getChampionshipWon()*50);
		return marketPrice;
	}
	public double calculateStarLevel(){
		double starLevel=0;
		starLevel=5+(getChampionshipWon()/10);
		return starLevel;
	}
}
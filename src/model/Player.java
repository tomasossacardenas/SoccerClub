package model;
public class Player extends Employee implements Price{

	//constants
	//atributes
	private int shirtNumber;
	private int goalsNumber;
	private int grade;
	private Positions position;
	//relations
	//CONSTRUCTOR
	public Player(String name, String identifier, int salary,int shirtNumber, int goalsNumber, int grade, Positions position){
		super(name, identifier, salary);
		this.shirtNumber=shirtNumber;
		this.goalsNumber=goalsNumber;
		this.grade=grade;
		this.position=position;
	}
//getters
	public int getShirtNumber(){
		return shirtNumber;
	}
	public int getGoalsNumber(){
		return goalsNumber;
	}
	public int getGrade(){
		return grade;
	}
	public Positions getPosition(){
		return position;
	}
/**
* This method shows the player info. <br>
*<b>Pos:</b>The information has been shown correctly<br>
* @return message, String that shows the info of the player.
*/
	public String showInfo(){
		String message;
		message="*************** Jugador ****************"+
		super.showInfo()+
		"\n**  Numero de Camisa: "+getShirtNumber()+
		"\n**  Numero de goles: "+getGoalsNumber()+
		"\n**  Calificacion: "+getGrade()+
		"\n**  Posicion: "+getPosition()+
		"\n**  Precio de mercado: "+calculateMarketPrice()+
		"\n**  Nivel de estrellas: "+calculateStarLevel()+
		"\n******************************************";

		return message;
	}
/**
* This method calculattes the market price of the player. <br>
*<b>Pos:</b>The market price has been calculated correctly.<br>
* @return marketPrice, double is the marketprice depending on the position and other factors.
*/
	public double calculateMarketPrice(){
		double marketPrice=0;
		if(getPosition()==Positions.PORTERO){
			marketPrice=(getSalary()*12)+(getGrade()*150);
		}
		if(getPosition()==Positions.DEFENSA){
			marketPrice=(getSalary()*13)+(getGrade()*125)+(getGoalsNumber()*100);
		}
		if(getPosition()==Positions.VOLANTE){
			marketPrice=(getSalary()*14)+(getGrade()*135)+(getGoalsNumber()*125);
		}
		if(getPosition()==Positions.DELANTERO){
			marketPrice=(getSalary()*15)+(getGrade()*145)+(getGoalsNumber()*150);
		}
		
		return marketPrice;
	}
/**
* This method calculates the star level of the player. <br>
*<b>Pos:</b>The star level has been calculated correctly.<br>
* @return starLevel, double is the star Level depending on the position and other factors.
*/
	public double calculateStarLevel(){
		double starLevel=0;
		if(getPosition()==Positions.PORTERO){
			starLevel=(getGrade()*0.9);
		}
		if(getPosition()==Positions.DEFENSA){
			starLevel=(getGrade()*0.9)+(getGoalsNumber()/100);
		}
		if(getPosition()==Positions.VOLANTE){
			starLevel=(getGrade()*0.9)+(getGoalsNumber()/90);
		}
		if(getPosition()==Positions.DELANTERO){
			starLevel=(getGrade()*0.9)+(getGoalsNumber()/80);
		}
		return starLevel;
	}
}
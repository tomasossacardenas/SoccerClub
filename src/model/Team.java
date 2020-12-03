package model;
import java.util.*;
public class Team{
	//constants
	public final static int ASSISTANTS_QUANTITY=3, MAX_PLAYERS=25;
//atributes
	private String name;
	//relations
	private ArrayList<Lineups> lineups;
	private PrincipalCoach coach;
	private Assistant[] assistants;
	private Player[] players;
	private Player[][] dressingRoom;
//CONSTRUCTOR
	public Team(String name){
		this.name=name;
		assistants=new Assistant[ASSISTANTS_QUANTITY];
		players=new Player[MAX_PLAYERS];
		lineups=new ArrayList<Lineups>();
		coach=null;
	}
//getters
	public String getName(){
		return name;
	}
	public PrincipalCoach getCoach(){
		return coach;
	}
/**
* This method adds an employee to a team. <br>
*<b>Pre:</b>The array players has been already created<br>
*<b>Pos:</b>The employee has been added correctly<br>
* @param employee , Employee is the employee which is going to be added to the team.
* @return message, String that shows the info of the team.
*/
	public String addEmployeeToTeam(Employee employee){
		String message="*** El empleado ya se encuentra en la nomina del equipo ***";
		boolean salir=false;
		boolean playerExists=false;
		boolean assistantExists=false;

		if (employee instanceof Player && playerExists==false){
			for(int i=0;i<MAX_PLAYERS;i++){
				if(players[i]!=null && players[i]==(Player)employee){
							playerExists=true;
				}
			}
			for(int i=0;i<MAX_PLAYERS&& salir==false && playerExists==false;i++){
				if (players[i]==null){
					players[i]=(Player)employee;
					salir=true;
					message="**** El jugador ha sido agregado al equipo ***";
				}
				if (salir==false){
					message="*** Cupos de jugadores llenos, no se pudo agregar el jugador ***";
				}
			}
		}
		if (employee instanceof Assistant){
			for(int i=0;i<ASSISTANTS_QUANTITY;i++){
				if(assistants[i]!=null && assistants[i]==(Assistant)employee){
							assistantExists=true;
				}
			}
			for(int i=0;i<ASSISTANTS_QUANTITY&& salir==false&& assistantExists==false;i++){
				if (assistants[i]==null){
					assistants[i]=(Assistant)employee;
					salir=true;
					message="*** El asistente ha sido agregado al equipo ***";
				}
				if (salir==false){
					message="*** Cupos de asistentes llenos, no se pudo agregar el asistente ***";
				}
			}
		}
		if(employee instanceof PrincipalCoach){
			if (coach==null){
				coach=(PrincipalCoach)employee;
				message="*** El tecnico ha sido agregado al equipo ***";
			}
			else{
				message="*** Ya existe un tecnico para este equipo, no se pudo agregar el tecnico ***";
			}
		}

		return message;
	}
/**
* This method shows the team info. <br>
*<b>Pre:</b>The array assistant has been already created<br>
*<b>Pre:</b>The array players has been already created<br>
*<b>Pos:</b>The information has been shown correctly<br>
* @return message, String that shows the info of the team.
*/
	public String showInfo(){
		String mensajeCoach="";
		if (coach!=null && coach.getActivo()==true){
			mensajeCoach=getCoach().getName();
		}
		String mensajeAssistants="";
		for(int i=0;i<ASSISTANTS_QUANTITY;i++){
			if (assistants[i]!=null && assistants[i].getActivo()==true){
				mensajeAssistants+=assistants[i].getName()+" ";
			}
		}
		String mensajePlayers="";
		for(int i=0;i<MAX_PLAYERS;i++){
			if (players[i]!=null && players[i].getActivo()==true){
				mensajePlayers+=players[i].getName()+" ";
			}
		}
		String message;
		message="**************** Equipo ***************"+
		"\n**  Nombre: "+getName()+
		"\n**  Entrenador: "+mensajeCoach+
		"\n**  Asistentes: "+mensajeAssistants+
		"\n**  Jugadores: "+mensajePlayers+
		"\n****************************************";
		return message;
	}
/**
* This method creates dressing rooms for the team. <br>
*<b>Pos:</b>The dressing rooms has been created<br>
* @param largo int, that indicates the lenght of the dressingroom. largo!=null.
* @param ancho int, that indicates the ancho of the dressingroom. ancho!=null.
*/
	public void createDressingRooms(int largo, int ancho){
		dressingRoom=new Player[largo][ancho];
	}
/**
* This method situate players in the dressing rooms. <br>
*<b>Pos:</b>the players has been organized correctly<br>
* @return mensaje, String that is the message that shows how the organization in the dressing rooms are.
*/
	public String situatePlayersInDressingRooms(){
		boolean salir=false;
		ArrayList<Integer>position=new ArrayList<Integer>();
		for(int i=0;i<players.length;i++){
			position.add(i);
		}
		Collections.shuffle(position);

		for(int i = 0; i < dressingRoom.length; i++){ 
			for(int j = 0; j < dressingRoom[i].length; j++){ 
				dressingRoom[i][j]=null;
			} 
		}
		for (int e=0; e<players.length; e++){
			salir=false;
				for ( int i = 0; i < dressingRoom.length && salir==false; i+=2 ){
				      for ( int j = 0; j < dressingRoom[i].length && salir==false; j+=2 ){
				          if (dressingRoom[i][j]==null){
				          	dressingRoom[i][j]=players[position.get(e)];
				          	salir=true;
				          }
				      }
		   		}
		}

		String mensaje="************** Ocupacion Vestuarios***********\n";
		for(int i = 0; i < dressingRoom.length; i++){ 
			for(int j = 0; j < dressingRoom[i].length; j++){ 
				if(dressingRoom[i][j]!=null){
					mensaje+="["+dressingRoom[i][j].getName()+"]";	// Imprime el nombre del jugador en dicha posicion 
				}
				else{
					mensaje+="[ ]";
				}
			} 
			mensaje+="\n";	// imprime el salto de linea para imprimir la siguiente fila
		}

		return mensaje;
	}
/**
* This method adds a lineup to a team. <br>
*<b>Pos:</b>The employee has been hired and added to de arraylist<br>
* @param date String, is the date of the lineup. date!="".
* @param tactic Tactic, is the tactic of the lineup. tactic=!null.
* @param lineup String, is the name of the lineup. lineup!="".
* @param defensas int, is the number of defensors. defensas1=null.
* @param volantes int, is the number of middlefielders. volantes!=null.
* @param delanteros int, is the number of forwarders. delanteros!=null.
* @return mensaje, String that is the lineup as a matrix.
*/
	public String addLineup(String date, Tactics tactic, String lineup,  int defensas, int volantes, int delanteros){
		int[][] formation=new int[10][7];
		String mensaje="*****************ALINEACION CREADA****************\n";
		String name=defensas+"-"+volantes+"-"+delanteros;

		for(int i = 0; i < formation.length; i++){ 
			for(int j = 0; j < formation[i].length; j++){ 
					formation[i][j]=0;
			} 
		}
		
		for ( int i = 0; i < 10; i++ ){
			for ( int j = 0; j < 7; j++ ){
  			if(i==2){
  				for (int e=0;e<delanteros;e++){
  					formation[i][e]=1;
  				}
  				
  			}
  			if(i==5){
  				for (int v=0;v<volantes;v++){
  					formation[i][v]=1;

  				}
  				
  			}
  			if(i==8){
  				for (int d=0;d<defensas;d++){
  					formation[i][d]=1;
  				}
  				
  			}
			}
		}


		for(int i = 0; i < formation.length; i++){ 
			for(int j = 0; j < formation[i].length; j++){ 
					mensaje+="["+formation[i][j]+"]";	// Imprime el nombre del entrenador en dicha posicion 
			} 
			mensaje+="\n";	// imprime el salto de linea
		}

		lineups.add(new Lineups(name, date, formation, tactic));// añade alineacion al equipo

		return mensaje;
	}
/**
* This method returns the Lineup. <br>
*<b>Pos:</b>The lineup has been returned<br>
* @param name String is the name of the lineup. name!="".
* @return lineup, Lineups is the lineup.
*/
	public Lineups returnLineup(String name){
		Lineups lineup=null;
		for (int i=0;i<lineups.size();i++){
			if(lineups.get(i)!=null && lineups.get(i).getName().equals(name)){
				lineup=lineups.get(i);
			}
		}
		return lineup;
	}
/**
* This method returns the formation depending the team and the name of the lineup. <br>
*<b>Pos:</b>the formation has been returned<br>
* @param name , String,  is the name of the lineup name!="".
* @return mensaje, String that is the lineup.
*/
	public String returnFormation(String name){
		String mensaje=returnLineup(name).getFormation();
		return mensaje;//metodo que me muestra la formacion en el formato defensas-volantes-delanteros
	}

}
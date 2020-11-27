package model;
import java.util.*;
public class Team{
	//constants
	public final static int ASSISTANTS_QUANTITY=3, MAX_PLAYERS=25, NUM_DRESSINGROOMS=2;
//atributes
	private String name;
	//relations
	private ArrayList<Lineups> lineups;
	private PrincipalCoach coach;
	private Assistant[] assistants;
	private Player[] players;
	private DressingRoom dressingRoom1;
	private DressingRoom dressingRoom2;
//CONSTRUCTOR
	public Team(String name){
		this.name=name;
		assistants=new Assistant[ASSISTANTS_QUANTITY];
		players=new Player[MAX_PLAYERS];
		dressingRoom1= new DressingRoom("A",6,7);
		dressingRoom2= new DressingRoom("B",7,7);
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
	public void createDressingRooms(){
		dressingRoom1=new DressingRoom("A", 6,7);
		dressingRoom2=new DressingRoom("B", 7, 7);
	}
	public String situatePlayersInDressingRooms(){
		return "hola";
	}
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
	public Lineups returnLineup(String name){
		Lineups lineup=null;
		for (int i=0;i<lineups.size();i++){
			if(lineups.get(i)!=null && lineups.get(i).getName().equals(name)){
				lineup=lineups.get(i);
			}
		}
		return lineup;
	}	
	public String returnFormation(String name){
		String mensaje=returnLineup(name).getFormation();
		return mensaje;//metodo que me muestra la formacion en el formato defensas-volantes-delanteros
	}

}
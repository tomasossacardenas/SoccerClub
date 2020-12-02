package model;
import java.util.ArrayList;
import java.util.*;
public class Club{
//constants
	public final static int NUM_TEAMS=2, ALTO_MAXIMO=6, ANCHO_MAXIMO=6;
//atributes
	private String name;
	private String nit;
	private String foundationDate;
//relations
	public ArrayList<Employee> employees;
	private Coach [][] offices;
	private Team[] teams;
//CONSTRUCTOR
	public Club(String name, String nit, String foundationDate){
		this.name=name;
		this.nit=nit;
		this.foundationDate=foundationDate;
		employees=new ArrayList<Employee>();
		offices=new Coach [ALTO_MAXIMO][ANCHO_MAXIMO];
		teams=new Team[NUM_TEAMS];
	}
//getters
	public String getName(){
		return name;
	}
	public String getNit(){
		return nit;
	}
	public String getFoundationDate(){
		return foundationDate;
	}
	public String showInfo(){
		String message;
		message="****************** Club ****************"+
		"\n**  Nombre: "+getName()+
		"\n**  NIT: "+getNit()+
		"\n**  Fecha Fundacion: "+getFoundationDate()+
		"\n*************************************";
		for(int i=0;i<employees.size();i++){
			message+=showTeamsInfo(i);
		}
		for(int i=0;i<employees.size();i++){
			message+=showInfo(i);
		}

		return message;
	}
	public String createTeams(){
		String mensaje;
		teams[0]=new Team("A");
		teams[1]=new Team ("B");
		mensaje="*************En el club hay dos equipos con el nombre A y B respectivamente******************";

		return mensaje;
	}
	public void createDressingRooms(){
		for(int i=0; i<NUM_TEAMS;i++){
			if(i==0){
				teams[i].createDressingRooms(7,6);
			}
			if(i==1){
				teams[i].createDressingRooms(7,7);
			}
		}
	}
	public boolean findEmployee(String identifier){
		boolean salir=false;
		boolean found=false;
		for(int i=0;i<employees.size() && salir==false;i++){
			if (employees.get(i)!=null && employees.get(i).getIdentifier().equals(identifier)){
				found=true;
			}
		}
		return found;
	}
	public Positions returnPosition(int positionOption){//positionOption TIENE que ser un numero 1, 2 , 3 o 4 obligatoriamente
		Positions tp= Positions.PORTERO;
		switch (positionOption){
			case 1:
				tp=Positions.PORTERO;
				break;
			case 2:
				tp=Positions.DEFENSA;
				break;
			case 3:
				tp=Positions.VOLANTE;
				break;
			case 4:
				tp=Positions.DELANTERO;
				break;
		}
		return tp;
	}
	public Expertice returnExpertice(int experticeOption){//experticeOption TIENE que ser un numero 1, 2 , 3, 4, 5 o 6 obligatoriamente
		Expertice tp= Expertice.DEFENSIVO;
		switch (experticeOption){
			case 1:
				tp=Expertice.DEFENSIVO;
				break;
			case 2:
				tp=Expertice.OFENSIVO;
				break;
			case 3:
				tp=Expertice.POSESION;
				break;
			case 4:
				tp=Expertice.JUGADASDELABORATORIO;
				break;
			case 5:
				tp=Expertice.MANEJOARQUEROS;
				break;
			case 6:
				tp=Expertice.TACTICAS;
				break;
		}
		return tp;
	}
	public Tactics returnTactic(int tacticOption){//positionOption TIENE que ser un numero 1, 2 , 3 o 4 obligatoriamente
		Tactics tp= Tactics.POSESION;
		switch (tacticOption){
			case 1:
				tp=Tactics.POSESION;
				break;
			case 2:
				tp=Tactics.CONTRAATAQUE;
				break;
			case 3:
				tp=Tactics.PRESIONALTA;
				break;
			case 4:
				tp=Tactics.PORDEFECTO;
				break;
		}
		return tp;
	}
	public String hireEmployee(String userName,String identifier, int salary, int shirtNumber, int goalsNumber, int grade, int positionOption){
		boolean found= findEmployee(identifier);
		String message="El jugador ha sido registrado";
		if (found==false){
				employees.add(new Player(userName, identifier, salary,  shirtNumber, goalsNumber, grade, returnPosition(positionOption)));
		}
		else{
			message="Este empleado ya existe en el club";
		}
		return message;
	}
	public String hireEmployee(String userName,String identifier, int salary,int experienceYears,int teamsNumber, int championshipsWon, String[]championships){
		boolean found= findEmployee(identifier);
		String message="El entrenador principal ha sido registrado";
		if (found==false){
					employees.add(new PrincipalCoach(userName, identifier, salary, experienceYears, teamsNumber, championshipsWon, championships));
		}
		else{
			message="El empleado con este identificador ya existe en el club";
		}
		return message;
	}
	public String hireEmployee(String userName,String identifier, int salary,int experienceYears,boolean soccerPlayer,int[]experticeNumbers){
		boolean found= findEmployee(identifier);
		Expertice[]expertices=new Expertice[experticeNumbers.length];
		String message="El entrenador aisstente ha sido registrado";

		for(int i=0;i<experticeNumbers.length;i++){
			expertices[i]=returnExpertice(experticeNumbers[i]);
		}
		if (found==false){
				employees.add(new Assistant(userName, identifier, salary, experienceYears, soccerPlayer, expertices));

		}
		else{
			message="El empleado con este identificador ya existe en el club";
		}
		return message;
	}
	public String fireEmployee(String identifier){
		Employee empleadox=returnEmployee(identifier);
		String message="El jugador ha sido despedido";
		boolean salir=false;
		if (empleadox!=null){
			for(int i=0;i<employees.size() && salir==false;i++){
				if (employees.get(i)==empleadox){
					employees.get(i).setActivo(false);
					salir=true;
				}
			}
		}
		else{
			message="No existe ningun empleado con este numero de indentificacion";
		}
		return message;
	}
	public String setEmployeeInfo(String name, String identifier, int salary){
		String mensaje="";
		Employee employeex=returnEmployee(identifier);
		if(employeex!=null){
			employeex.setName(name);
			employeex.setSalary(salary);
			mensaje="Los datos del empleado "+identifier+" se han modificado correctamente";
		}
		else{
			mensaje="No existe ningun empleado con el identificador "+identifier;
		}
		return mensaje;
	}
	public String showInfo(int i){
		String message="";
		if (employees.get(i)!=null && employees.get(i).getActivo()==true){
			message=employees.get(i).showInfo();
			
		}
		return message;
	}
	public String showTeamsInfo(int i){
		String message="";
		if (teams[i]!=null){
			message=teams[i].showInfo();
			
		}
		return message;
	}
	public Employee returnEmployee(String identifier){
		boolean salir=false;
		Employee empleadox=null;
		for(int i=0;i<employees.size() && salir==false;i++){
			if (employees.get(i)!=null && employees.get(i).getIdentifier().equals(identifier)){
				empleadox=employees.get(i);
			}
		}
		return empleadox;
	}
	public Team returnTeam(String team){
		boolean salir=false;
		Team teamx=null;
		for(int i=0;i<NUM_TEAMS && salir==false;i++){
			if (teams[i]!=null && teams[i].getName().equals(team)){
				teamx=teams[i];
			}
		}
		return teamx;
	}
	public String addEmployeeToTeam(String identifier, String team){
		String mensaje;
		Employee employeex=returnEmployee(identifier);
		Team teamx=returnTeam(team.toUpperCase());
		if (employeex!=null){
			if(employeex.getActivo()==true){
				mensaje=teamx.addEmployeeToTeam(employeex);
			}
			else{
				mensaje="Este empleado no puede ser añadido a ningun equipo ya que es inactivo";
			}
		}

		else{
			mensaje="El empleado con el numero de identificacion "+identifier+" no existe";
		}

		return mensaje;
	}
	public String showMarketPrices(){
		String globalMessage;
		String mensajePlayers="*********************** Jugadores ********************";
		String mensajeCoaches="*********************** Entrenadores ********************";
		for (int i=0;i<employees.size();i++){
			if(employees.get(i) instanceof Player){
				Player employee=(Player)employees.get(i);
				mensajePlayers+="**  Nombre: "+employee.getName()+"\n"+
								"**  Precio de mercado: "+employee.calculateMarketPrice()+"\n";
			}
			if(employees.get(i) instanceof PrincipalCoach){
				PrincipalCoach employee2=(PrincipalCoach)employees.get(i);
				mensajeCoaches+="**  Nombre: "+employee2.getName()+"\n"+
								"**  Precio de mercado: "+employee2.calculateMarketPrice()+"\n";
			}
		}
		globalMessage=mensajePlayers+mensajeCoaches;
		return globalMessage;
	}
	public String situateCoachesInOffices(){
		String mensaje="***  Se han situado los entrenadores en las oficinas";
		boolean salir=false;
		for(int i = 0; i < offices.length; i++){ 
			for(int j = 0; j < offices[i].length; j++){ 
				offices[i][j]=null;
			} 
		}
		for (int e=0; e<employees.size(); e++){
			salir=false;
			if(employees.get(e) instanceof PrincipalCoach && employees.get(e).getActivo()==true || employees.get(e) instanceof Assistant && employees.get(e).getActivo()==true){
				for ( int i = 0; i < ALTO_MAXIMO && salir==false; i+=2 ){
				      for ( int j = 0; j < ANCHO_MAXIMO && salir==false; j+=2 ){
				          if (offices[i][j]==null){
				          	offices[i][j]=(Coach)employees.get(e);
				          	salir=true;
				          }
				      }
		   		}

			}
		}

		return mensaje;
	}
	public String showCoachesInOffices(){
		String mensaje="************** Ocupacion Oficinas ***********\n";
		for(int i = 0; i < offices.length; i++){ 
			for(int j = 0; j < offices[i].length; j++){ 
				if(offices[i][j]!=null){
					mensaje+="["+offices[i][j].getName()+"]";	// Imprime el nombre del entrenador en dicha posicion 
				}
				else{
					mensaje+="[ ]";
				}
			} 
			mensaje+="\n";	// imprime el salto de linea para imprimir la siguiente fila
		}

		return mensaje;
	}
	public String addLineupToTeam(String date, int tacticOption, String team, int defensas, int volantes, int delanteros){
		String mensaje="";
		String lineup=defensas+"-"+volantes+"-"+delanteros;
		mensaje=returnTeam(team).addLineup(date, returnTactic(tacticOption), lineup, defensas, volantes, delanteros);
		return mensaje;
	}
	public String returnFormation(String teamName, String lineupName){
		String mensaje=returnTeam(teamName).returnFormation(lineupName);
		return mensaje;
	}
	public String situatePlayersInDressingRooms(String teamName){
		Team teamx=returnTeam(teamName);
		String mensaje=teamx.situatePlayersInDressingRooms();
		return mensaje;
	}

}
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
/**
* This method shows the club info. <br>
*<b>Pre:</b>The arraylist employees has been already created<br>
*<b>Pos:</b>The method has been shown correctly<br>
* @return mensaje, String that shows the info of the club including info of players and teams.
*/
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
/**
* This method creates the two teams A and B. <br>
*<b>Pre:</b>The array teams has been already created<br>
*<b>Pos:</b>The teams has been creates correctly<br>
* @return mensaje, String that is the confirmation if the methos was succesfull or there was any error.
*/
	public String createTeams(){
		String mensaje;
		teams[0]=new Team("A");
		teams[1]=new Team ("B");
		mensaje="*************En el club hay dos equipos con el nombre A y B respectivamente******************";

		return mensaje;
	}
/**
* This method creates the dressing rooms for the two teams. <br>
*<b>Pre:</b>The array teams has been already created<br>
*<b>Pos:</b>The dressing rooms has been created correctly<br>
*/
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
/**
* This method finds an employee depending on the identifier in the parameter. <br>
*<b>Pre:</b>The arraylist employees has been already created<br>
*<b>Pos:</b>The employee has been found<br>
* @param identifier is te id of the employee that is going to be found.
* @return found, boolean that shows if the employee was found or not.
*/
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
/**
* This method returns the position of the player depending the option. <br>
*<b>Pos:</b>The posiiton has been returned<br>
* @param positionOption is the option that the user chose. positionOption!=null and positionOption=1,2,3,4;
* @return tp, Positions that is the position of the player.
*/
	public Positions returnPosition(int positionOption){
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
/**
* This method returns the expertice of the assistant depending the option. <br>
*<b>Pos:</b>The expertice has been returned<br>
* @param experticeOption is the option that the user chose. experticeOption!=null and experticeOption=1,2,3,4,5,6
* @return tp, Expertice is the expertice of the assiatnt depending on the option.
*/
	public Expertice returnExpertice(int experticeOption){
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
/**
* This method returns the tactic depending the option. <br>
*<b>Pos:</b>The tactic has been returned<br>
* @param tacticOption is the option that the user chose. tacticOption!=null and tacticOption=1,2,3,4
* @return tp, Tactics is the tactic of the formation depending on the option.
*/
	public Tactics returnTactic(int tacticOption){
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
/**
* This method returns the team depending the name. <br>
*<b>Pos:</b>The team has been returned<br>
* @param team String, is the name of the team. team!="".
* @return teamx, Team that is the team with the name passed in the parameter.
*/
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
/**
* This method returns the employee depending the identifier. <br>
*<b>Pre:</b>The arraylist employees has been already created<br>
*<b>Pos:</b>The employee
 has been returned<br>
* @param identifier , String,  is the identifier of the employee identifier!="".
* @return empleadox, Employee that is the employee with the identifier passed in the parameter.
*/
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
/**
* This method hires an employee and it to the arraylist of employees. <br>
*<b>Pre:</b>The arrayist employees has been already created<br>
*<b>Pos:</b>The employee has been hired and added to de arraylist<br>
* @param userName String, is the name of the player. userName!="".
* @param identifier String, is the identifier of the player. identifier!="".
* @param salary int, is the salary of the player. salary!=null.
* @param shirtNumber int, is the shortNumber of the player. shirtNumber!=null.
* @param goalsNumber int is the number of goals of the player. goalsNumber!=null.
* @param grade int, is the grade of the player. grade!=null and grade=1,2,3,4,5.
* @param positionOption int,  is the option of the position of the player. positionOption!=null and positionOption=1,2,3,4.
* @return message, String that is the confrmation if the method had been done correctly or there is any error.
*/
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
/**
* This method hires an employee and it to the arraylist of employees. <br>
*<b>Pre:</b>The arrayist employees has been already created<br>
*<b>Pos:</b>The employee has been hired and added to de arraylist<br>
* @param userName String, is the name of the coach. userName!="".
* @param identifier String, is the identifier of the coach. identifier!="".
* @param salary int, is the salary of the coach. salary!=null.
* @param experienceYears int, is the years of experience of the coach. experienceYears!=null.
* @param teamsNumber int is the number of teams directed by the coach. teamsNumber!=null.
* @param championshipsWon int, is the number of championships won by the coach. championshipWon!=null.
* @param championships Array of Strings,  is the name of the championships won by the coach.
* @return message, String that is the confrmation if the method had been done correctly or there is any error.
*/
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
/**
* This method hires an employee and it to the arraylist of employees. <br>
*<b>Pre:</b>The arrayist employees has been already created<br>
*<b>Pos:</b>The employee has been hired and added to de arraylist<br>
* @param userName String, is the name of the coach. userName!="".
* @param identifier String, is the identifier of the coach. identifier!="".
* @param salary int, is the salary of the coach. salary!=null.
* @param experienceYears int, is the years of experience of the coach. experienceYears!=null.
* @param soccerPlayer boolean, is if the assistant has been a soccer player before. soccerPlayer=true, false.
* @param experticeNumbers Array of int,  is the number of the option of expertices that the assistant has.
* @return message, String that is the confrmation if the method had been done correctly or there is any error.
*/
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
/**
* This method fires an employee and changes it state to inactive. <br>
*<b>Pre:</b>The arrayist employees has been already created<br>
*<b>Pos:</b>The employee has been fired and its status has been changed to inactive<br>
* @param identifier String, is the identifier of the employee. identifier!="".
* @return message, String that is the confrmation if the method had been done correctly or there is any error.
*/
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
/**
* This method sets the employee information. <br>
*<b>Pos:</b>The employee has been hired and added to de arraylist<br>
* @param name String, is the name of the employee. name!="".
* @param identifier String, is the identifier of the employee. identifier!="".
* @param salary int, is the salary of the employee. salary!=null.
* @return mensaje, String that is the confrmation if the method had been done correctly or there is any error.
*/
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
/**
* This method shows the information of all the employees. <br>
*<b>Pre:</b>The arraylist employees has been already created<br>
*<b>Pos:</b>The information has been shown<br>
* @param i int, is the number of iteration to show all employees info. i!=null.
* @return mensaje, String that is the info of all employees
*/
	public String showInfo(int i){
		String message="";
		if (employees.get(i)!=null && employees.get(i).getActivo()==true){
			message=employees.get(i).showInfo();
			
		}
		return message;
	}
/**
* This method shows the information of all the teams. <br>
*<b>Pre:</b>The array teams has been already created<br>
*<b>Pos:</b>The information has been shown<br>
* @param i int, is the number of iteration to show all teams info. i!=null.
* @return mensaje, String that is the info of all teams.
*/
	public String showTeamsInfo(int i){
		String message="";
		if (teams[i]!=null){
			message=teams[i].showInfo();
			
		}
		return message;
	}
/**
* This method returns the tactic depending the option. <br>
*<b>Pos:</b>The employee has been added to the team<br>
* @param identifier String,  is the identifier of the employee. identifier!="".
* @param team String, is the name of the team that the employee is going to be added. team!="".
* @return mensaje, String that is the confrmation if the method had been done correctly or there is any error.
*/
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
/**
* This method shows the marketprices of all the employees. <br>
*<b>Pre:</b>The arraylist employees has been already created<br>
*<b>Pos:</b>The market prices has been shown<br>
* @return globalMessage, String that shows the marketprices of all players and coaches.

*/
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
/**
* This method organizes the coaches in the offices with the post-pandemic rules. <br>
*<b>Pre:</b>The matrix offices has been already created<br>
*<b>Pos:</b>The coaches has been organized in the offices<br>
* @return mensaje, String that is the confrmation if the method had been done correctly or there is any error.

*/
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
/**
* This method shows the organization of the coaches in the offices <br>
*<b>Pre:</b>The matrix offices has been already created<br>
*<b>Pos:</b>The organization of the coaches in the offices has been shown<br>
* @return mensaje, String that is the message that shows the organzation of the coaches in the offices.

*/
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
/**
* This method adds a lineup to a team. <br>
*<b>Pos:</b>The employee has been hired and added to de arraylist<br>
* @param date String, is the date of the lineup. date!="".
* @param tacticOption int, is the option of the tactic. tacticOption=!null.
* @param team String, is the name of the team. team!="".
* @param defensas int, is the number of defensors. defensas1=null.
* @param volantes int, is the number of middlefielders. volantes!=null.
* @param delanteros int, is the number of forwarders. delanteros!=null.
* @return mensaje, String that is the confirmation if the lineup has been added or not.

*/
	public String addLineupToTeam(String date, int tacticOption, String team, int defensas, int volantes, int delanteros){
		String mensaje="";
		String lineup=defensas+"-"+volantes+"-"+delanteros;
		mensaje=returnTeam(team).addLineup(date, returnTactic(tacticOption), lineup, defensas, volantes, delanteros);
		return mensaje;
	}
/**
* This method returns the formation depending the team and the name of the lineup. <br>
*<b>Pos:</b>the formation has been returned<br>
* @param teamName , String,  is the name of the team teamName!="".
* @param lineupName , String,  is the name of the lineup lineupName!="".
* @return mensaje, String that is the lineup.
*/
	public String returnFormation(String teamName, String lineupName){
		String mensaje=returnTeam(teamName).returnFormation(lineupName);
		return mensaje;
	}
/**
* This method situate players in the dressing rooms. <br>
*<b>Pos:</b>the players has been organized correctly<br>
* @param teamName , String,  is the name of the team in which its players are going to be organized teamName!="".
* @return mensaje, String that is the message that shows how the organization in the dressing rooms are.
*/
	public String situatePlayersInDressingRooms(String teamName){
		Team teamx=returnTeam(teamName);
		String mensaje=teamx.situatePlayersInDressingRooms();
		return mensaje;
	}

}
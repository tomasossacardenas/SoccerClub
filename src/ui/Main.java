package ui;
import model.Club;
import java.util.*;
public class Main{
public static Scanner entrada = new Scanner(System.in);
	public static void main (String[] args){
		System.out.println("********************* Datos del Club *******************");
		System.out.println("Cual es el nombre del club");
		String name=entrada.nextLine();
		System.out.println("Cual es el NIT del club");
		String nit=entrada.nextLine();
		System.out.println("Cual es la fecha de fundacion del club");
		String foundationDate=entrada.nextLine();
			Club club=new Club(name, nit, foundationDate);
			System.out.println(club.createTeams());
			club.createDressingRooms();
		System.out.println("**Se crearon los camerinos A(capacidad 42) y B(capacidad 49) para cada equipo");
		showMenu();
		chooseOption(club);
	}
	public static void showMenu(){
		System.out.println("");
		System.out.println("Digite el numero de la actividad que desea realizar: "+
			"\n 1. Contratar Empleado\n 2. Despedir Empleado\n "+
			"3. Mostrar informacion de todos los empleados\n "+
			"4. Mostrar informacion de los equipos\n 5. Agregar alineacion a un equipo\n "+
			"6. Ubicar entrenadores en las oficinas\n 7. Ubicar jugadores en los vestuarios\n "+
			"8. Mostrar la informacion de todo el club\n"+
			"9. Conocer el precio del mercado de los jugadores y entrenadores\n"+
			"10. Actualizar informacion de los empleados\n"+
			"11. Mostrar la ubicacion de los entrenadores en las oficinas");
	}
	public static void chooseOption(Club club){
		int menuOption=entrada.nextInt();entrada.nextLine();
		switch(menuOption){
			case 1:
				System.out.println("Que tipo de empleado va agregar, digite el numero correspondiente\n 1.Jugador\n 2.Entrenador Principal\n 3.Asistente Tecnico");
				int option=entrada.nextInt();entrada.nextLine();
				hireEmployee(club, option);
				showMenu();
				chooseOption(club);
				break;
			case 2:
				fireEmployee(club);
				showMenu();
				chooseOption(club);
				break;
			case 3:
				showEmployeesInfo(club);
				showMenu();
				chooseOption(club);
				break;
			case 4:
				showTeamsInfo(club);
				break;
			case 5:
				addLineupToTeam(club);
				showMenu();
				chooseOption(club);
				break;
			case 6:
				System.out.println(club.situateCoachesInOffices());
				showMenu();
				chooseOption(club);
				break;
			case 7:
				System.out.println("A cual equipo quiere organizarle los jugadores A o B");
				String team=entrada.nextLine().toUpperCase();
				System.out.println(club.situatePlayersInDressingRooms(team));
				showMenu();
				chooseOption(club);
				break;
			case 8:
				System.out.println(club.showInfo());
				showMenu();
				chooseOption(club);
				break;
			case 9:
				System.out.println(club.showMarketPrices());
				showMenu();
				chooseOption(club);
				break;
			case 10:
				System.out.println("Ingrese el identificador del empleado");
				String identifier=entrada.nextLine();
				System.out.println("Ingrese el nuevo nombre del empleado");
				String name=entrada.nextLine();			
				System.out.println("Ingrese el nuevo salario del empleado");
				int salary=entrada.nextInt();entrada.nextLine();
				System.out.println(club.setEmployeeInfo(name, identifier, salary));
				break;
			case 11:
				System.out.println(club.showCoachesInOffices());
				showMenu();
				chooseOption(club);
				break;
		}//switch
	}
	public static void hireEmployee(Club club, int option){
		String mensaje;
		if(option==1){
			System.out.println("Ingrese el Nombre del jugador");
			String userName=entrada.nextLine();
			System.out.println("Ingrese el identificador del jugador");
			String identifier=entrada.nextLine();
			System.out.println("Ingrese el salario del entrenador");
			int salary=entrada.nextInt();entrada.nextLine();
			System.out.println("Ingrese el numero de la camisa");
			int shirtNumber=entrada.nextInt();entrada.nextLine();
			System.out.println("Ingrese el numero de goles del jugador");
			int goalsNumber=entrada.nextInt();entrada.nextLine();
			System.out.println("Ingrese la calificacion del jugador");
			int grade=entrada.nextInt();entrada.nextLine();
			System.out.println("Ingrese la posicion del jugador\n 1.PORTERO\n 2. DEFENSA\n 3. VOLANTE\n 4. DELANTERO");
			int positionOption=entrada.nextInt();entrada.nextLine();
			System.out.println("Ingrese el equipo en el cual estara el jugador, A o B");
			String team=entrada.nextLine().toUpperCase();
			mensaje=club.hireEmployee(userName, identifier, salary,  shirtNumber, goalsNumber, grade, positionOption);
			System.out.println(mensaje);
			System.out.println(club.addEmployeeToTeam(identifier, team));
			showMenu();
			chooseOption(club);
		}
		if(option==2){

			System.out.println("Ingrese el Nombre del entrenador");
			String userName=entrada.nextLine();
			System.out.println("Ingrese el identificador del entrenador");
			String identifier=entrada.nextLine();
			System.out.println("Ingrese el salario del entrenador");
			int salary=entrada.nextInt();entrada.nextLine();
			System.out.println("Ingrese los años de experiencia");
			int experienceYears=entrada.nextInt();entrada.nextLine();
			System.out.println("Ingrese el numero de equipos a los que ha estado a cargo el entrenador");
			int teamsNumber=entrada.nextInt();entrada.nextLine();
			System.out.println("Ingrese el numero de campeonatos que ha conseguido el entrenador");
			int championshipsWon=entrada.nextInt();entrada.nextLine();
			String[] championships=new String[championshipsWon];//array de nombres de campeonatos ganados
			for (int i=0;i<championshipsWon;i++){
				System.out.println("Ingrese el nombre del campeonato ganado numero "+(i+1));
				String name=entrada.nextLine();
				championships[i]=name;

			}
			System.out.println("Ingrese el equipo en el cual estara el entrenador, A o B");
			String team=entrada.nextLine().toUpperCase();
			mensaje=club.hireEmployee(userName, identifier, salary, experienceYears, teamsNumber, championshipsWon, championships);
			System.out.println(mensaje);
			System.out.println(club.addEmployeeToTeam(identifier, team));
			showMenu();
			chooseOption(club);
		}
		if(option==3){
			System.out.println("Ingrese el Nombre del asistente");
			String userName=entrada.nextLine();
			System.out.println("Ingrese el identificador del asistente");
			String identifier=entrada.nextLine();
			System.out.println("Ingrese el salario del asistente");
			int salary=entrada.nextInt();entrada.nextLine();
			System.out.println("Ingrese los años de experiencia");
			int experienceYears=entrada.nextInt();entrada.nextLine();
			System.out.println("El asistente fue jugador de futbol anteriormente? reponda True o False");
			boolean soccerPlayer=entrada.nextBoolean();
			System.out.println("Cuantas experticias tiene el asistente");
			int experticeCuantity=entrada.nextInt();entrada.nextLine();
			System.out.println("Ingrese el equipo en el cual estara el entrenador, A o B");
			String team=entrada.nextLine().toUpperCase();
			int[]numberExpertices=new int[experticeCuantity];
			for (int i=0;i<experticeCuantity;i++){
				System.out.println("Elija la experticia numero "+(i+1)+" del asistente\n 1.DEFENSIVO\n 2. OFENSIVO\n 3. POSESION\n 4. JUGADAS DE LABORATORIO\n 5.MANEJO DE ARQUEROS\n 6. TACTICAS");
				int experticeOption=entrada.nextInt();entrada.nextLine();
				numberExpertices[i]=experticeOption;
			}
			mensaje=club.hireEmployee(userName, identifier, salary, experienceYears, soccerPlayer, numberExpertices);
			System.out.println(mensaje);
			System.out.println(club.addEmployeeToTeam(identifier, team));
		}	
	}
	public static void fireEmployee(Club club){
		String mensaje;
			System.out.println("Ingrese el identificador del empleado");
			String identifier=entrada.nextLine();
			mensaje=club.fireEmployee(identifier);
	}
	public static void showEmployeesInfo(Club club){
		for(int i=0;i<club.employees.size();i++){
			if(club.showInfo(i)!=""){
			System.out.println(club.showInfo(i));
			}
		}
	}
	public static void showTeamsInfo(Club club){
		for(int i=0;i<club.NUM_TEAMS;i++){
			if(club.showTeamsInfo(i)!=""){
			System.out.println(club.showTeamsInfo(i));
			}
		}
		showMenu();
		chooseOption(club);
	}
	public static void addLineupToTeam(Club club){
		System.out.println("Fecha de creacion de la alineacion");
		String date=entrada.nextLine();
		System.out.println("A que equipo va a añadir la formacion A o B");
		String team=entrada.nextLine();
		System.out.println("Ingrese la tactica de la alineacion\n 1.POSESION\n 2. CONTRA ATAQUE\n 3. PRESION ALTA\n 4. POR DEFECTO");
		int tacticOption=entrada.nextInt();entrada.nextLine();
		System.out.println("Cuantos defensas hay?");
		int defensas=entrada.nextInt();entrada.nextLine();
		System.out.println("Cuantos volantes hay");
		int volantes=entrada.nextInt();entrada.nextLine();
		System.out.println("Cuantos delanteros hay?");
		int delanteros=entrada.nextInt();entrada.nextLine();
		String formationName=defensas+"-"+volantes+"-"+delanteros;
		if(defensas+volantes+delanteros==10){
			System.out.println(club.addLineupToTeam(date, tacticOption, team, defensas, volantes, delanteros));
			System.out.println("Su formacion es: "+club.returnFormation(team, formationName));
		}
		else{
			System.out.println("Recuerde que entre los jugadores de las 3 posiciones deben haber 10 de ellos");
		}
	}

}
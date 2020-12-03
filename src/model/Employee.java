package model;
	enum Expertice{
	DEFENSIVO, OFENSIVO, POSESION, JUGADASDELABORATORIO, MANEJOARQUEROS, TACTICAS;
	}
	enum Positions{
	PORTERO, DEFENSA, VOLANTE, DELANTERO
	}
public abstract class Employee{
	//constants

//atributes
	private String name;
	private String identifier;
	private int salary;
	private boolean activo;
	//relations

//CONSTRUCTOR
	public Employee(String name, String identifier, int salary){
		this.name=name;
		this.identifier=identifier;
		this.salary=salary;
		activo=true;
	}
//getters
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getIdentifier(){
		return identifier;
	}
	public int getSalary(){
		return salary;
	}
	public void setSalary(int salary){
		this.salary=salary;
	}
	public boolean getActivo(){
		return activo;
	}

	public void setActivo(boolean activo){
		this.activo=activo;
	}
/**
* This method shows the employee info. <br>
*<b>Pos:</b>The information has been shown correctly<br>
* @return message, String that shows the info of the employee.
*/
	public String showInfo(){
		String message;
		message="\n**  Nombre: "+getName()+
		"\n**  Empleado Activo?: "+getActivo()+
		"\n**  Identificador: "+getIdentifier()+
		"\n**  Salario: "+getSalary();
		return message;
	}

}
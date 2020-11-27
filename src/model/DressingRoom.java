package model;
public class DressingRoom{
	//constants
	//atrbutes
	private String name;
	private int largo;
	private int ancho;
	//relations
	private Player[][] players;

	public DressingRoom(String name,int largo, int ancho){
		this.name=name;
		this.largo=largo;
		this.ancho=ancho;
		players=new Player[largo][ancho];
	}


}
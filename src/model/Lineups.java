package model;
import java.util.*;
 enum Tactics{
	POSESION, CONTRAATAQUE, PRESIONALTA, PORDEFECTO;	
}
public class Lineups{
	//constants
//atributes
	private String name;
	private String date;
	private int[][] formation;
	private Tactics tactic;
	//relations
//CONSTRUCTOR
	public Lineups(String name,String date, int[][] formation, Tactics tactic){
		this.name=name;
		this.date=date;
		this.formation=formation;
		this.tactic=tactic;
	}
//getters
	public String getDate(){
		return date;
	}
	public String getName(){
		return name;
	}
/**
* This method returns the formation in the format defensors-middlefielders-forwarders. <br>
*<b>Pos:</b>The formation has been returned correctly.<br>
* @return lineup, is the formation in the format defensors-middlefielders-forwarders.
*/
	public String getFormation(){
		int defensaCounter=0;
		int delanteroCounter=0;
		int volanteCounter=0;
		for(int i = 0; i < formation.length; i++){ 
			for(int j = 0; j < formation[i].length; j++){ 
				if(i==2){
					if(formation[i][j]==1){
						delanteroCounter++;
					}
  				
  				}
	  			if(i==5){
					if(formation[i][j]==1){
						volanteCounter++;

	  				}
	  				
	  			}
	  			if(i==8){
					if(formation[i][j]==1){
						defensaCounter++;

	  				}
	  				
	  			}
			} 	
		}
		String lineup=defensaCounter+"-"+volanteCounter+"-"+delanteroCounter;
		return lineup;
	}


}
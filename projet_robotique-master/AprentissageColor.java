package Learn_Detect;




import java.util.ArrayList;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.ColorHTSensor;
import lejos.robotics.Color;

public class AprentissageColor{
	public static final ColorHTSensor cs = new ColorHTSensor(SensorPort.S1);
	public ArrayList<MyColor> savedColor;

	public AprentissageColor() {
		savedColor = new ArrayList<MyColor>();
	}

	public ArrayList<MyColor> myColors() {
		return savedColor;
	}

	//tester si une couleur existe deja dans la liste
	public boolean isKnown( Color c) {
		for (MyColor myColor : savedColor) {
			if (myColor.myDistance(c) < 50)
				   return true;
		}
		
	    return false;
	}

	//ajouter une couleur à la liste si elle n'est pas deja presente
	public boolean addColor() {

		LCD.drawString("1er sauvegarde", 2, 2);
		Button.waitForAnyPress();
		Color in1 = cs.getColor();
		
		LCD.clear();
		LCD.drawString("2eme sauvegarde", 2, 2);
		Button.waitForAnyPress();
		Color in2 = cs.getColor();
		
		LCD.clear();
		LCD.drawString("3eme sauvegarde", 2, 2);
		Button.waitForAnyPress();
		Color in3 = cs.getColor();
		
		LCD.clear();
		
        //calculer la quantite du blue,vert et du rouge de la couleur
		int red = (in1.getRed() + in2.getRed() + in3.getRed()) / 3;
		int green = (in1.getGreen() + in2.getGreen() + in3.getGreen()) / 3;
		int blue = (in1.getBlue() + in2.getBlue() + in3.getBlue()) / 3;
		
		/*System.out.println(red);
		System.out.println(green);
		System.out.println(blue);
		LCD.clear();*/
		
		//creer la couleur
		Color c = new Color(red, green, blue);
   
		//si la liste des couleurs connues est vide on rajoute la couleur
		if (savedColor.isEmpty()) {

			
			Button.waitForAnyPress();
			savedColor.add(new MyColor(c));
			
			LCD.drawString("ajout", 1, 1);
			Button.waitForAnyPress();
			
			return true;
		}
		
			//si  la couleur n'existe pas  dans la liste on la rajoute
			if (!isKnown( c)) {
				savedColor.add(new MyColor(c));
				LCD.drawString("ajoutuuuu", 1, 1);
				Button.waitForAnyPress();
				return true;
			}
  
		//si la couleur existe deja ou elle est proche d'une couleur qui existe deja  
		LCD.drawString("couleur connue", 1, 1);
		Button.waitForAnyPress();
		return false;
	}
}


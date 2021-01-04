
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.robotics.Color;
public class curve {

	public static int kp=45;                                              
	public static int tp = 450;
	public static int angle=1;
	public static int v_forward = 348;
	public static int coef_right=0;
	public static int coef_left=0; 
	public static NXTRegulatedMotor left;
	public static NXTRegulatedMotor right;


	public static void main(String[] args) {
		ApprentissageColor acColor = new ApprentissageColor();

		Button.waitForAnyPress();
		LCD.clear();

		acColor.addColor();
		LCD.clear();
		LCD.drawString("put in a right color", 2, 2);
		Button.waitForAnyPress();
		MyColor myColor = acColor.myColors().get(0);
	
		left = Motor.C;
		right = Motor.A;
		
		
		left.setSpeed(v_forward);
    	right.setSpeed(v_forward);
    	left.forward();
    	right.forward();
			
			while (!Button.ESCAPE.isDown()) {
				Color c = ApprentissageColor.cs.getColor();
				double dist = myColor.myDistance(c);
				
				
				 if(dist<52) {
				    	//System.out.print("right");
				    	
				    	left.setSpeed(tp+(angle*coef_right));
				    	right.setSpeed(kp);
				    	coef_right++;
				    	coef_left=0;
					
				    }else {
				    	
				    	//System.out.print("left");
				    	left.setSpeed(kp);
				    	right.setSpeed(tp+(angle*coef_left));
				    	coef_left++;
				    	coef_right=0;
				    	
				    }
				    if(coef_left>5 || coef_right>5) {
				    	coef_left=1;
				    	coef_right=1;
				    }
			}

		}

	}


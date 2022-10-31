
public class GFG {
	
	public static void main(String[] args) {
		
		MotorCycle mc = new MotorCycle();
		mc.getEnergy();
		mc.getWheels();
		mc.isGears();
		
//		MotorCycle mc1 = new Bicycle();//compilation error
		
		Bicycle bc = new MotorCycle();
		bc.isGears();
		bc.getWheels();
//		bc.getEnergy();//Error
		
		Bicycle bc1	= new Bicycle();
		bc1.getWheels();
		bc1.isGears();
	}
	
	//It does not call methods defined by variables type.
	//But defined by instance type is called.
	
}

class MotorCycle extends Bicycle{
	private String energy;

	public String getEnergy() {
		return energy;
	}

	public void setEnergy(String energy) {
		this.energy = energy;
	}
}

class Bicycle{
	private int wheels;
	protected boolean gears;
	public int getWheels() {
		return wheels;
	}
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	public boolean isGears() {
		return gears;
	}
	public void setGears(boolean gears) {
		this.gears = gears;
	}
}


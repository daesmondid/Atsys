package models;

public class Lighting extends Device {
	
	private int intensity;

	public Lighting(int id, String name, String deviceId, int pin, LogicBoard logicBoard, int intensity) {
		super(id, name, deviceId, pin, logicBoard);
		this.intensity = intensity;
	}

	public int getIntensity() {
		return intensity;
	}

	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}
	
}

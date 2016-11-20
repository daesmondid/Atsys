package models;

import enumerations.PowerStatus;

public class Climate extends Device {
	
	private int temperature;
	private PowerStatus powerStatus;

	public Climate(int id, String name, String deviceId, int pin, LogicBoard logicBoard, int temperature, PowerStatus powerStatus) {
		super(id, name, deviceId, pin, logicBoard);
		this.temperature = temperature;
		this.powerStatus = powerStatus;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public PowerStatus getPowerStatus() {
		return powerStatus;
	}

	public void setPowerStatus(PowerStatus powerStatus) {
		this.powerStatus = powerStatus;
	}
	
}

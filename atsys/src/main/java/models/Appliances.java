package models;

import enumerations.PowerStatus;

public class Appliances extends Device {
	
	private PowerStatus powerStatus;

	public Appliances(int id, String name, String deviceId, int pin, LogicBoard logicBoard, PowerStatus powerStatus) {
		super(id, name, deviceId, pin, logicBoard);
		this.powerStatus = powerStatus;
	}

	public PowerStatus getPowerStatus() {
		return powerStatus;
	}

	public void setPowerStatus(PowerStatus powerStatus) {
		this.powerStatus = powerStatus;
	}
	
}

package models;

import enumerations.DoorStatus;

public class GarageDoor extends Device {
	
	private DoorStatus doorStatus;

	public GarageDoor(int id, String name, String deviceId, int pin, LogicBoard logicBoard, DoorStatus doorStatus) {
		super(id, name, deviceId, pin, logicBoard);
		this.doorStatus = doorStatus;
	}

	public DoorStatus getDoorStatus() {
		return doorStatus;
	}

	public void setDoorStatus(DoorStatus doorStatus) {
		this.doorStatus = doorStatus;
	}
	
}

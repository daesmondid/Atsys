package models;

import enumerations.LockStatus;

public class DoorLock extends Device {
	
	private LockStatus lockStatus;

	public DoorLock(int id, String name, String deviceId, int pin, LogicBoard logicBoard, LockStatus lockStatus) {
		super(id, name, deviceId, pin, logicBoard);
		this.lockStatus = lockStatus;
	}

	public LockStatus getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(LockStatus lockStatus) {
		this.lockStatus = lockStatus;
	}
	
}

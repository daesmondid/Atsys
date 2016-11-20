package models;

import utils.AtsysDefaultUtil;

public class Device {
	
	protected int id;
	protected String name;
	protected String deviceId;
	protected int pin;
	protected LogicBoard logicBoard;
	
	public Device(String name, int pin, LogicBoard logicBoard) {
		super();
		this.id = -1;
		this.name = name;
		this.deviceId = AtsysDefaultUtil.getSaltString();
		this.pin = pin;
		this.logicBoard = logicBoard;
	}
	
	public Device(int id, String name, String deviceId, int pin, LogicBoard logicBoard) {
		super();
		this.id = id;
		this.name = name;
		this.deviceId = deviceId;
		this.pin = pin;
		this.logicBoard = logicBoard;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
	
	public LogicBoard getLogicBoard() {
		return logicBoard;
	}

	public void setLogicBoard(LogicBoard logicBoard) {
		this.logicBoard = logicBoard;
	}

}

package models;

import enumerations.PowerStatus;

public class AudioSystem extends Device {
	
	private int volumeLevel;
	private int musicId;
	private PowerStatus powerStatus;

	public AudioSystem(int id, String name, String deviceId, int pin, LogicBoard logicBoard, int volumeLevel, int musicId, PowerStatus powerStatus) {
		super(id, name, deviceId, pin, logicBoard);
		this.volumeLevel = volumeLevel;
		this.musicId = musicId;
		this.powerStatus = powerStatus;
	}

	public int getVolumeLevel() {
		return volumeLevel;
	}

	public void setVolumeLevel(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	public int getMusicId() {
		return musicId;
	}

	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}

	public PowerStatus getPowerStatus() {
		return powerStatus;
	}

	public void setPowerStatus(PowerStatus powerStatus) {
		this.powerStatus = powerStatus;
	}
	
}

package com.techelevator;

public class Television {
	
	private boolean isOn;
	private int currentChannel;
	private int currentVolume ;
	
	
	
	
	
	
	
	
	public Television() {
		this.isOn = isOn;
		this.currentChannel = 3;
		this.currentVolume = 2;
	}
	public boolean isOn() {
		return isOn;
	}
	public int getCurrentChannel() {
		return currentChannel;
	}
	public int getCurrentVolume() {
		return currentVolume;
	}
	
	
	public void turnOff() {
		isOn = false;
	};
	

	public void turnOn() {
		isOn = true;
	}
	
	public void changeChannel(int newChannel) {
		currentChannel = newChannel;
	}
	
	
	
	public void channelUp() {
		if (currentChannel>17 && isOn) {
			currentChannel = 18;
		}else if (isOn) {
			currentChannel++;
		}
		}
	
	public void channelDown() {
		if (currentChannel<4 && isOn) {
			currentChannel = 18;
		}else if (isOn) {
			currentChannel--;
		}
		
	}
	
	public void raiseVolume() {
		
		
		if (currentVolume <10 && isOn) {
			currentVolume++;
		} else if (isOn) {
			currentVolume = 10;
		}
		
	}
	
	public void lowerVolume() {
		if (currentVolume >0 && isOn) {
			currentVolume--;
		} else if (isOn){
			currentVolume = 0;
		}
		
	}
	
	

}

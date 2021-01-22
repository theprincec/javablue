package com.techelevator;

public class Television {

	private boolean isOn = false;
	private int currentChannel = 3;
	private int currentVolume = 2;
	
	
	//turns off the TV.
	public void turnOff(){
		this.isOn = false;
	}
	
	//turns the TV on and also 
	//resets the channel to three and 
	//the volume level to two.
	public void turnOn(){
		this.isOn = true;
		this.currentChannel = 3;
		this.currentVolume = 2;
	}
	// changes the current channel—only 
	//if it's on—to the value 
	// of newChannel as long as it's between 3 and 18.
    public void changeChannel(int newChannel){
		if (this.isOn && newChannel >= 3 && newChannel <= 18) {
			this.currentChannel = newChannel;
		}
	}
    
    //increases the current channel by one, 
    // only if it's on. 
    // If the value goes past 18, then the current channel 
    //    should be set to three.
    public void channelUp(){
		if (this.isOn) {
			this.currentChannel++;
			if (this.currentChannel > 18) {
				this.currentChannel = 3;
			}
		}
	}
    
    //decreases the current channel by one, 
    // only if it's on. 
    //If the value goes below three, 
    //  then the current channel should be set to 18.
    public void channelDown(){
		if (this.isOn) {
			this.currentChannel--;
			if (this.currentChannel < 3) {
				this.currentChannel = 18;
			}
		}
	}
    
    //increases the volume by one, 
    //only if it's on. 
    //The limit is 10.
    public void raiseVolume(){
		if (this.isOn && this.currentVolume < 10) {
			this.currentVolume++;
		}
	}
    
    //decreases the volume by one, 
    //only if it's on. 
    //The limit is zero.
    public void lowerVolume() {
		if (this.isOn && this.currentVolume > 0) {
			this.currentVolume--;
		}
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
	
}

package com.techelevator.models;

public class City {

    private String full_name;
    private int geoname_id;
    private int population;
    private Location location;
    
    public void setFullName(String full_name) {
        this.full_name = full_name;
    }

    public void setGeonameId(int geoname_id){
        this.geoname_id = geoname_id;
    }

    public String getFull_name(){
        return full_name;
    }

    

    
    public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
	
	

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String toString(){
        return full_name + " (" + population + ")";
    }


    

}

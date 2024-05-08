package cz.tul.weather;

import cz.tul.weather.Weather.Condition;

public class Current {
	
	private long lastUpdatedEpoch;
    private String lastUpdated;
    private double tempC;
    private double tempF;
    private boolean isDay;
    private Condition condition;
    private double windMph;
    private double windKph;
    private int windDegree;
    private String windDir;
    private double pressureMb;
    private double pressureIn;
    private double precipMm;
    private double precipIn;
    private int humidity;
    private int cloud;
    private double feelslikeC;
    private double feelslikeF;
    private double visKm;
    private double visMiles;
    private double uv;
    private double gustMph;
    private double gustKph;
    
	public long getLastUpdatedEpoch() {
		return lastUpdatedEpoch;
	}
	public void setLastUpdatedEpoch(long lastUpdatedEpoch) {
		this.lastUpdatedEpoch = lastUpdatedEpoch;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public double getTempC() {
		return tempC;
	}
	public void setTempC(double tempC) {
		this.tempC = tempC;
	}
	public double getTempF() {
		return tempF;
	}
	public void setTempF(double tempF) {
		this.tempF = tempF;
	}
	public boolean isDay() {
		return isDay;
	}
	public void setDay(boolean isDay) {
		this.isDay = isDay;
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	public double getWindMph() {
		return windMph;
	}
	public void setWindMph(double windMph) {
		this.windMph = windMph;
	}
	public double getWindKph() {
		return windKph;
	}
	public void setWindKph(double windKph) {
		this.windKph = windKph;
	}
	public int getWindDegree() {
		return windDegree;
	}
	public void setWindDegree(int windDegree) {
		this.windDegree = windDegree;
	}
	public String getWindDir() {
		return windDir;
	}
	public void setWindDir(String windDir) {
		this.windDir = windDir;
	}
	public double getPressureMb() {
		return pressureMb;
	}
	public void setPressureMb(double pressureMb) {
		this.pressureMb = pressureMb;
	}
	public double getPressureIn() {
		return pressureIn;
	}
	public void setPressureIn(double pressureIn) {
		this.pressureIn = pressureIn;
	}
	public double getPrecipMm() {
		return precipMm;
	}
	public void setPrecipMm(double precipMm) {
		this.precipMm = precipMm;
	}
	public double getPrecipIn() {
		return precipIn;
	}
	public void setPrecipIn(double precipIn) {
		this.precipIn = precipIn;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public int getCloud() {
		return cloud;
	}
	public void setCloud(int cloud) {
		this.cloud = cloud;
	}
	public double getFeelslikeC() {
		return feelslikeC;
	}
	public void setFeelslikeC(double feelslikeC) {
		this.feelslikeC = feelslikeC;
	}
	public double getFeelslikeF() {
		return feelslikeF;
	}
	public void setFeelslikeF(double feelslikeF) {
		this.feelslikeF = feelslikeF;
	}
	public double getVisKm() {
		return visKm;
	}
	public void setVisKm(double visKm) {
		this.visKm = visKm;
	}
	public double getVisMiles() {
		return visMiles;
	}
	public void setVisMiles(double visMiles) {
		this.visMiles = visMiles;
	}
	public double getUv() {
		return uv;
	}
	public void setUv(double uv) {
		this.uv = uv;
	}
	public double getGustMph() {
		return gustMph;
	}
	public void setGustMph(double gustMph) {
		this.gustMph = gustMph;
	}
	public double getGustKph() {
		return gustKph;
	}
	public void setGustKph(double gustKph) {
		this.gustKph = gustKph;
	}

    
    
    
}
package me.javer.tools.objects;

import java.util.UUID;

public class Ban{
	
	private UUID uuid;
	private String victim;
	private String punisher;
	private String reason;
	private long banTime;
	private long validateTill;
	
	public Ban(String punisher, String victim){
		this.victim = victim;
		this.punisher = punisher;
	}
	
	public UUID getUUID(){
		return uuid;
	}
	
	public String getVictim() {
		return victim;
	}

	public String getPunisher() {
		return punisher;
	}

	public String getReason() {
		return reason;
	}

	public long getBanTime() {
		return banTime;
	}

	public long getValidateTill() {
		return validateTill;
	}

	public void setUUID(UUID uuid){
		this.uuid = uuid;
	}
	
	public void setVictim(String victim) {
		this.victim = victim;
	}

	public void setPunisher(String punisher) {
		this.punisher = punisher;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setBanTime(long banTime) {
		this.banTime = banTime;
	}

	public void setValidateTill(long validateTill) {
		this.validateTill = validateTill;
	}
}

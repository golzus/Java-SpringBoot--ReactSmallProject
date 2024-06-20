package Adv.models;

import jakarta.persistence.*;

@Entity
@Table (name = "advertisement_by_visits") 
public class AdvertisementByVisits extends BaseAdvertisement{
	@Column
	private int visitsSoFar;
	@Column
	private int desiredVisits;
	
	public int getVisitsSoFar() {
		return visitsSoFar;
	}
	public void setVisitsSoFar(int visitsSoFar) {
		this.visitsSoFar = visitsSoFar;
	}
	public int getDesiredVisits() {
		return desiredVisits;
	}
	public void setDesiredVisits(int desiredVisits) {
		this.desiredVisits = desiredVisits;
	}
	
}
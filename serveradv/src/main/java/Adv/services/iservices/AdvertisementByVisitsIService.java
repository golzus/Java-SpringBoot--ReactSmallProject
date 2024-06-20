


package Adv.services.iservices;

import java.util.List;


import Adv.models.AdvertisementByVisits;

public interface AdvertisementByVisitsIService{
	boolean add(AdvertisementByVisits adv);
	String placeCurrent(String location);
	List<AdvertisementByVisits> getAll();
} 

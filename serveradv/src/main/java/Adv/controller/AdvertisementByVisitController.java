package Adv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Adv.models.AdvertisementByVisits;
import Adv.services.iservices.AdvertisementByVisitsIService;
import Adv.services.services.AdvertisementByVisitsService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/advertisement/byVisits")
public class AdvertisementByVisitController {
	@Autowired
	private AdvertisementByVisitsService ser;

	@PostMapping("/add")
	public Boolean add(@RequestBody AdvertisementByVisits adv) {
		return ser.add(adv);
	}

	@PostMapping("/currentAdv/{location}")
	public String currentAdv(@PathVariable String location) {
		return ser.placeCurrent(location);
	}

	@GetMapping("/")
	public List<AdvertisementByVisits> getAll() {
		return ser.getAll();
	}
}

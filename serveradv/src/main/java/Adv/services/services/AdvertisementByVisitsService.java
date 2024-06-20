
package Adv.services.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Adv.daoRepository.AdvertisementByVisitsRepository;
import Adv.models.AdvertisementByVisits;
import Adv.services.iservices.AdvertisementByVisitsIService;

@Service
public class AdvertisementByVisitsService implements AdvertisementByVisitsIService {
	@Autowired
	private AdvertisementByVisitsRepository rep;

	@Override
	public boolean add(AdvertisementByVisits adv) {
//		adv.setDesiredVisits();
		adv.setStatus(true);
		if (rep.existsById(adv.getId()))
			return false;
		rep.save(adv);
		return true;
	}

	@Override
	public String placeCurrent(String location) {
		List<AdvertisementByVisits> l = new ArrayList<>();
		String str = "";
		for (AdvertisementByVisits adv : rep.findAll()) {
			if (adv.getLocation() == location && adv.getStatus()) {
				if (adv.getDesiredVisits() - adv.getVisitsSoFar() <= 0) {
					adv.setStatus(false);
					str = "";
				} else
					str = adv.getPath();
			}
		}
		return str;
	}

//	@Override
//	public List<AdvertisementByVisits> getAll() {
//
//		List<AdvertisementByVisits> l = new ArrayList<>();
//		rep.findAll().forEach(adv -> {
//			if ((adv.getDesiredVisits() - adv.getVisitsSoFar()) <= 0)
//				adv.setStatus(false);
//			else {
//				adv.setVisitsSoFar(adv.getVisitsSoFar() + 1);
//				l.add(adv);
//			}
//			rep.save(l);
//
//		});
//		if (l == null)
//			return null;
//		return l;
//	}
//	

	@Override
	public List<AdvertisementByVisits> getAll() {
		List<AdvertisementByVisits> a = new ArrayList<>();
		rep.findAll().forEach(u -> {
			if ((u.getDesiredVisits() - u.getVisitsSoFar()) <= 0) {
				u.setStatus(false);
				System.out.println(u.getPath()+"de"+u.getDesiredVisits()+"fa "+u.getVisitsSoFar());
				System.out.println(u.getDesiredVisits() - u.getVisitsSoFar());
			} else {
				u.setVisitsSoFar(u.getVisitsSoFar() + 1);

				a.add(u);

			}
			rep.save(u);
		});

		return a;
	}

}
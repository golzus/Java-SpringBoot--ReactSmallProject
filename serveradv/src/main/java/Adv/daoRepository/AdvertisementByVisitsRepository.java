package Adv.daoRepository;
import org.springframework.data.repository.CrudRepository;

import Adv.models.AdvertisementByVisits;
import Adv.models.BaseAdvertisement;

public interface AdvertisementByVisitsRepository extends CrudRepository<AdvertisementByVisits,Integer>{}
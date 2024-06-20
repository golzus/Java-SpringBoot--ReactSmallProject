package Adv.daoRepository;

import org.springframework.data.repository.CrudRepository;

import Adv.models.User;

public interface UserRepository extends CrudRepository<User,String>{}
package com.devserv.users.service;


import java.util.List;


import org.springframework.stereotype.Component;

import com.devserv.users.entity.Users;
import com.devserv.users.repository.UsersRepository;

@Component
public class UsersService {

	private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    public Users saveUser(Users users) {
    	return usersRepository.save(users);
    }

    public Users getUserByName(String name){
        return usersRepository.findByFirstName(name);
    }


}

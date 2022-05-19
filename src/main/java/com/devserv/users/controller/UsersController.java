package com.devserv.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devserv.users.entity.Users;
import com.devserv.users.links.UserLinks;
import com.devserv.users.service.UsersService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/")
public class UsersController {

	@Autowired
	UsersService usersService;

	@GetMapping(path = UserLinks.LIST_USERS)
    public ResponseEntity<?> listUsers() {
        log.info("UsersController:  list users");
        List<Users> resource = usersService.getUsers();
        return ResponseEntity.ok(resource);
    }
    @GetMapping(path = UserLinks.GET_USER)
        public ResponseEntity<?> takeUser(String i) {
            log.info("UsersController:user");
            Users resource = usersService.getUserByName(i);
            return ResponseEntity.ok(resource);
        }

	@PostMapping(path = UserLinks.ADD_USER)
	public ResponseEntity<?> saveUser(@RequestBody Users user) {
        log.info("UsersController:  add/save users");
        Users resource = usersService.saveUser(user);
        return ResponseEntity.ok(resource);
    }
}

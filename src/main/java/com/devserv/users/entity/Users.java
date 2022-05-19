package com.devserv.users.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


import lombok.Data;

@Entity
@Data
public class Users {

	@Id
	@Column
    private int id;

    @Column
    @NotNull(message="{NotNull.User.firstName}")
    private String firstName;

    @Column
    @NotNull(message="{NotNull.User.password}")
    private String password;

    @Column
    @NotNull(message="{NotNull.User.email}")
    private String email;

    @Column
    private String role="user";

    @Column
    private int bloking=0;

}

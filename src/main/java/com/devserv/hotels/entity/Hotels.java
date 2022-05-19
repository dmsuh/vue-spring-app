package com.devserv.hotels.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


import lombok.Data;

@Entity
@Data
public class Hotels {

	@Id
	@Column
    private long id;

    @Column
    @NotNull(message="{NotNull.Hotels.nameH}")
    private String nameH;

    @Column
    @NotNull(message="{NotNull.Hotels.type}")
    private String type;

    @Column
    @NotNull(message="{NotNull.Hotels.adress}")
    private String adress;

}

package com.company.data;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public abstract class Root {

    private int id;
    private Date created;

    public Root() {
        this.created = new Date();
    }
}

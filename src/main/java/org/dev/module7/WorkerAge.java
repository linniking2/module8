package org.dev.module7;

import java.sql.Date;

public class WorkerAge {

    private String type;
    private String name;
    private Date birthday;

    public WorkerAge(String type, String name, Date birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    public String getType(){
        return type;
    }

    public String getName(){
        return name;
    }

    public Date getBirthday(){
        return birthday;
    }
}

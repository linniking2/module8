package org.dev.module8;

import lombok.Data;

@Data
public class Client {

    private long id;
    private String name;

    public Client(long id, String name) {
        this.id = id;
        this.name = name;
    }
}

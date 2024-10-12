package org.dev.module6;

public class Project {
    private int id;
    private int duration;

    public Project(int id, int duration) {
        this.id = id;
        this.duration = duration;
    }

    public int getId(){
        return id;
    }

    public int getDuration(){
        return duration;
    }
}

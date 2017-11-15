package com.goeckeler.excercises.festival.database.model;

public class GigData {
    private String order;
    private String song;
    private String act;

    public GigData(String order, String song, String act) {
        this.order = order;
        this.song = song;
        this.act = act;
    }

    public String getOrder() {
        return order;
    }

    public String getSong() {
        return song;
    }

    public String getAct() {
        return act;
    }
}

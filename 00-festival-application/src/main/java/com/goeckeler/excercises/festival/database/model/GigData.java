package com.goeckeler.excercises.festival.database.model;

public class GigData
{
  private String order;
  private String song;
  private String act;

  public GigData(final String order, final String song, final String act) {
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

  @Override
  public String toString() {
    return "#" + getOrder() + ":" + getSong() + " by " + getAct();
  }
}

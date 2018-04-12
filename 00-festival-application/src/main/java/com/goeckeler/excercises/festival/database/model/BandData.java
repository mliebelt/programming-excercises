package com.goeckeler.excercises.festival.database.model;

import com.goeckeler.excercises.festival.domain.Named;
import org.apache.commons.lang3.StringUtils;

public class BandData
  implements
  Named
{
  private String name;
  private String artists;

  public BandData(final String name, final String artists) {
    assert name != null;
    assert artists != null;

    this.name = name;
    this.artists = artists;
  }

  @Override
  public String getName() {
    return StringUtils.defaultString(name, "Unknown");
  }

  public String getArtists() {
    return artists;
  }

  @Override
  public String toString() {
    return getName() + " (" + getArtists() + ")";
  }
}

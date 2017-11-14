package com.goeckeler.excercises.festival.model.technical;

import com.goeckeler.excercises.festival.model.domain.Named;

public class BandData implements Named {
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
        return name;
    }

    public String getArtists() {
        return artists;
    }
}

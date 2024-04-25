package org.bdteam.tracks.provider;

import org.bdteam.tracks.domain.Track;

public interface PriceProvider {
    void addPriceToTrack(Track track);
}

package org.bdteam.tracks.dao;

import org.bdteam.tracks.domain.Artist;
import org.bdteam.tracks.domain.Track;

import java.util.List;

public interface ArtistRepository {
    List<Artist> getAllArtist();
    Artist insert(Artist artist);
    boolean delete(int id);
    boolean update(Artist artist);
    Artist findById(int id);
    Artist findByName(String name);
}

package org.bdteam.tracks.dao;

import org.bdteam.tracks.domain.Artist;
import org.bdteam.tracks.domain.MediaType;
import org.bdteam.tracks.domain.Track;

import java.time.Duration;
import java.util.List;

public interface TrackRepository {
    Track insert(Track track);
    boolean delete(int id);
    boolean update(Track track);
    Track findById(int id);
    List<Track> getAll();
    List<Track> tracksByYear(int year);
    List<Artist> artistsByTrack(int id);
    List<Track> tracksByArtist(int id);
    List<Track> tracksByDuration(String type, Duration duration);
    List<Track> tracksByMediaType(MediaType mediaType);
}

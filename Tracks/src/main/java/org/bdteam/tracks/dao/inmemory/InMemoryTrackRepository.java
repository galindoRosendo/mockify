package org.bdteam.tracks.dao.inmemory;

import org.bdteam.tracks.dao.TrackRepository;
import org.bdteam.tracks.domain.Artist;
import org.bdteam.tracks.domain.MediaType;
import org.bdteam.tracks.domain.Track;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.adapter.AbstractReactiveWebInitializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class InMemoryTrackRepository implements TrackRepository {

    private Map<Integer, Track> tracks = new HashMap<>();
    private int nextId = 1;
    @Override
    public Track insert(Track track) {
        int id = nextId++;
        track.setIdTrack(id);
        track.setTitle(track.getTitle());
        track.setDuration(track.getDuration());

        tracks.put(track.getIdTrack(), track);
        return track;
    }

    @Override
    public boolean delete(int id) {
        return tracks.remove(id) != null;
    }

    @Override
    public boolean update(Track track) {
        return tracks.replace(track.getIdTrack(), track) != null;
    }

    @Override
    public Track findById(int id) {
        return tracks.get(id);
    }

    @Override
    public List<Track> getAll() {
        return new ArrayList<>(tracks.values());
    }

    @Override
    public List<Track> tracksByYear(int year) {
        return new ArrayList<Track>(this.tracks.values()).stream().filter(track -> track.getIssueDate().getYear() == year).collect(Collectors.toList());
    }

    @Override
    public List<Artist> artistsByTrack(int id) {
     return tracks.get(id).getArtists();
    }

    @Override
    public List<Track> tracksByArtist(int id) {
        return new ArrayList<Track>(this.tracks.values()).stream().filter(track -> track.getArtistsIds().contains(id)).collect(Collectors.toList());
    }

    @Override
    public List<Track> tracksByDuration(String type, Duration duration) {
        List<Track> result = null;

        switch (type){
            case "longer":
                result = new ArrayList<Track>(this.tracks.values()).stream().filter(track -> track.getDuration().toMinutes() > duration.toMinutes()).collect(Collectors.toList());
                break;
            case "shorter":
                result = new ArrayList<Track>(this.tracks.values()).stream().filter(track -> track.getDuration().toMinutes() < duration.toMinutes()).collect(Collectors.toList());
                break;
            case "equal":
                result = new ArrayList<Track>(this.tracks.values()).stream().filter(track -> track.getDuration().toMinutes() == duration.toMinutes()).collect(Collectors.toList());
                break;
        }


         return result;
    }

    @Override
    public List<Track> tracksByMediaType(MediaType mediaType) {
        return new ArrayList<Track>(this.tracks.values()).stream().filter(truck -> truck.getMediaType() == mediaType).collect(Collectors.toList());
    }

}

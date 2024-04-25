package org.bdteam.tracks.service;

import org.bdteam.tracks.dao.TrackRepository;
import org.bdteam.tracks.domain.Artist;
import org.bdteam.tracks.domain.MediaType;
import org.bdteam.tracks.domain.Track;
import org.bdteam.tracks.provider.PriceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class TrackService {
    private TrackRepository trackRepository;
    @Autowired
    private PriceProvider priceProvider;
    public TrackService(TrackRepository trackRepository){
        this.trackRepository = trackRepository;
    }
    public Track addTrack(Track track){
        Track trackInserted = trackRepository.insert(track);
        return trackInserted;
    }
    public boolean deleteTrack(int id) {
        return trackRepository.delete(id);
    }
    public boolean updateTrack(Track track){
        return trackRepository.update(track);
    }
    public Track findById(int id){
        Track result = trackRepository.findById(id);
        priceProvider.addPriceToTrack(result);
        return result;
    }
    public List<Track> getAll(){
        List<Track> allTracks = trackRepository.getAll();

        allTracks.forEach(priceProvider::addPriceToTrack);

        return allTracks;
    }
    public List<Track> tracksByMediaType(MediaType mediaType){

        return trackRepository.tracksByMediaType(mediaType);
    }
    public List<Track> tracksByYear(int year){
        return trackRepository.tracksByYear(year);
    }
    public List<Artist> artistsByTrack(Integer id){
        return trackRepository.artistsByTrack(id);
    }
    public List<Track> tracksByArtist(Integer id) { return trackRepository.tracksByArtist(id); }
    public List<Track> tracksByDuration(String type, Duration duration){
        return trackRepository.tracksByDuration(type, duration);
    }
}

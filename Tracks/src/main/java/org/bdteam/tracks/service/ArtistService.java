package org.bdteam.tracks.service;

import org.bdteam.tracks.dao.ArtistRepository;
import org.bdteam.tracks.domain.Artist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    private ArtistRepository artistRepository;
    public ArtistService(ArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }
    public Artist addArtist(Artist artist){
        Artist trackInserted = artistRepository.insert(artist);
        return trackInserted;
    }
    public boolean deleteArtist(int id) {
        return artistRepository.delete(id);
    }
    public boolean updateArtist(Artist artist){
        return artistRepository.update(artist);
    }
    public Artist findById(int id){
        return artistRepository.findById(id);
    }
    public Artist findByName(String name){
        return artistRepository.findByName(name);
    }
    public List<Artist> getAll() {return artistRepository.getAllArtist(); }
}

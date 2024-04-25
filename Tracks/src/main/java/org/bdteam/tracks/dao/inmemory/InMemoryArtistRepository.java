package org.bdteam.tracks.dao.inmemory;

import org.bdteam.tracks.dao.ArtistRepository;
import org.bdteam.tracks.domain.Artist;
import org.bdteam.tracks.domain.Track;
import org.bdteam.tracks.service.ArtistService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class InMemoryArtistRepository implements ArtistRepository {
    private Map<Integer, Artist> artists = new HashMap<>();
    private int nextId = 1;

    @Override
    public List<Artist> getAllArtist() {
        return new ArrayList<>(artists.values());
    }

    @Override
    public Artist insert(Artist artist) {
        int id = nextId++;
        artist.setIdArtist(id);
        artist.setName(artist.getName());
        artists.put(artist.getIdArtist(), artist);

        return artist;
    }

    @Override
    public boolean delete(int id) {
        return artists.remove(id) != null;
    }

    @Override
    public boolean update(Artist artist) {
        return artists.replace(artist.getIdArtist(), artist) != null;
    }

    @Override
    public Artist findById(int id) {
        return artists.get(id);
    }
    @Override
    public Artist findByName(String name) {
        return this.artists.values().stream().filter(artist -> artist.getName().equals(name)).findFirst().orElse(null);
    }
}

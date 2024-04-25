package org.bdteam.tracks.controller;

import org.bdteam.tracks.domain.Artist;
import org.bdteam.tracks.domain.Track;
import org.bdteam.tracks.service.ArtistService;
import org.bdteam.tracks.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @Autowired
    private TrackService trackService;

    @GetMapping
    public List<Artist> getAllArtist(){
        List<Artist> artists = artistService.getAll();
        return artists;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getArtistById(@PathVariable("id") int id){
        Artist artist = artistService.findById(id);
        if(artist == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No artist with id: " + id);
        }
        return ResponseEntity.ok(artist);
    }
    @GetMapping("/ByName/{name}")
    public ResponseEntity<?> getArtistByName(@PathVariable("name") String name){
        Artist artist = artistService.findByName(name);
        if(artist == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No artist with name: " + name);
        }
        return ResponseEntity.ok(artist);
    }
    @GetMapping("/tracksByArtist/{trackId}")
    public ResponseEntity<?> getTracksByArtist(@PathVariable("trackId") int trackId){
        List<Track> tracks = trackService.tracksByArtist(trackId);
        if(tracks == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No tracks with artist: " + trackId);
        }
        return ResponseEntity.ok(tracks);
    }

    @PostMapping()
    public ResponseEntity<?> addArtist(@RequestBody Artist artist){
        Artist newArtist = artistService.addArtist(artist);

        URI newResource = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(artist.getIdArtist())
                .toUri();

        return ResponseEntity.created(newResource).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArtist(@PathVariable("id") int id) {
        boolean result = artistService.deleteArtist(id);
        if(!result) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("No artist with id: " + id);
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping ResponseEntity<?> updateArtist(@RequestBody Artist artist){
        boolean result = artistService.updateArtist(artist);
        if(!result){
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
                    .body("No artist with id: " + artist.getIdArtist());
        }
        return ResponseEntity.noContent().build();
    }
}

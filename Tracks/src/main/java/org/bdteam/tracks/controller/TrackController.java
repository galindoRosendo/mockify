package org.bdteam.tracks.controller;

import org.bdteam.tracks.domain.Artist;
import org.bdteam.tracks.domain.MediaType;
import org.bdteam.tracks.domain.Track;
import org.bdteam.tracks.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/track")
public class TrackController {
    @Autowired
    private TrackService trackService;

    @GetMapping
    public List<Track> getAllTracks() {
        List<Track> tracks = trackService.getAll();
        return tracks;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTrack(@PathVariable("id") int id) {
        Track track = trackService.findById(id);
        if (track == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No track with id: " + id);
        }
        return ResponseEntity.ok(track);
    }
    @GetMapping("/ByMediaType/{mediaType}")
    public ResponseEntity<?> getTrackByMediaType(@PathVariable("mediaType") MediaType mediaType) {
        List<Track> tracks = trackService.tracksByMediaType(mediaType);
        if (tracks == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No tracks with that media type: " + mediaType.name());
        }
        return ResponseEntity.ok(tracks);
    }
    @GetMapping("/ByYear/{year}")
    public ResponseEntity<?> getTrackByYear(@PathVariable("year") int year) {
        List<Track> tracks = trackService.tracksByYear(year);
        if (tracks == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No tracks with that media type: " + year);
        }
        return ResponseEntity.ok(tracks);
    }
    @GetMapping("/ArtistsByTrack/{trackId}")
    public ResponseEntity<?> getTracksByArtist(@PathVariable("trackId") int trackId) {
        List<Artist> artists = trackService.artistsByTrack(trackId);
        if (artists == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No artists in the track: " + trackId);
        }
        return ResponseEntity.ok(artists);
    }
    @GetMapping("/ByDuration/{type}/{duration}")
    public ResponseEntity<?> getTracksByDuration(@PathVariable("type") String type, @PathVariable("duration") Duration duration) {
        List<Track> tracks = trackService.tracksByDuration(type, duration);
        if (tracks == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No tracks with that duration: " + type + " and " + duration.toMinutes() + "minutes");
        }
        return ResponseEntity.ok(tracks);
    }
    @PostMapping
    public ResponseEntity<?> addTrack(@RequestBody Track track) {
        Track newTrack = trackService.addTrack(track);

        //http://localhost:8080/adopter/3

        URI newResource = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(track.getIdTrack())
                .toUri();

        //return ResponseEntity.created(newResource).body(newTrack);
        return ResponseEntity.created(newResource).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable("id") int id) {
        boolean result = trackService.deleteTrack(id);
        if(!result) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No track with id: " + id);
        }

        return ResponseEntity.noContent().build();
    }
    @PutMapping
    public ResponseEntity<?> updateTrack(@RequestBody Track adopter) {
        boolean result = trackService.updateTrack(adopter);
        if(!result) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No track with id: " + adopter.getIdTrack());
        }
        return ResponseEntity.noContent().build();
    }
}
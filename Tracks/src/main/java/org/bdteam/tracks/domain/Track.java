package org.bdteam.tracks.domain;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Track {
    Integer idTrack;
    String title;
    List<Artist> artists;
    LocalDate issueDate;
    MediaType mediaType;
    Duration duration;
    Double price;

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getIdTrack() {
        return idTrack;
    }
    public void setIdTrack(Integer idTrack) {
        this.idTrack = idTrack;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<Artist> getArtists() {
        return artists;
    }
    public List<Integer> getArtistsIds() {
        return artists.stream().map(a-> a.getIdArtist()).collect(Collectors.toList());
    }
    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
    public LocalDate getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }
    public MediaType getMediaType() {
        return mediaType;
    }
    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }
    public Duration getDuration() {
        return duration;
    }
    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}

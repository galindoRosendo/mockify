package org.bdteam.tracks.jconfig;

import org.bdteam.tracks.dao.TrackRepository;
import org.bdteam.tracks.dao.inmemory.InMemoryTrackRepository;
import org.bdteam.tracks.service.TrackService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"org.bdteam.tracks"})
public class TracksConfig {

//    @Bean
//    public TrackRepository tracksRepository(){
//        TrackRepository dao = new InMemoryTrackRepository();
//        return dao;
//    }
//    @Bean
//    public TrackService trackService(){
//        TrackService service = new TrackService();
//
//        TrackRepository dao = tracksRepository();
//        service.setTrackRepository(dao);
//        return service;
//    }
}

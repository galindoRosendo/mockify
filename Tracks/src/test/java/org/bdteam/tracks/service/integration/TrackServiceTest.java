package org.bdteam.tracks.service.integration;

import org.bdteam.tracks.domain.MediaType;
import org.bdteam.tracks.domain.Track;
import org.bdteam.tracks.service.TrackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TrackServiceTest {
    @Autowired
    private TrackService trackService;

    @BeforeEach
    public void beforeEach(){

    }

    @Test
    public void testTrackServiceInsert(){
        Track track = new Track();
        track.setTitle("one");
        track.setMediaType(MediaType.Mp3);

        Track insertedTrack = trackService.addTrack(track);
        assertNotNull(insertedTrack);
        assertEquals(1, insertedTrack.getIdTrack());
    }

    @Test
    public void testTrackServiceGetById(){

    }
    @Test
    public void testTrackServiceUpdate(){

    }

    @Test
    public void testTrackServiceDelete(){

    }

    @Test
    public void testTrackServiceGetAll(){

    }

    @Test
    public void testTrackServiceGetByMediaType(){

    }

    @Test
    public void testTrackServiceGetByYear(){

    }

    @Test
    public void testTrackServiceGetByLongerDuration(){

    }
    @Test
    public void testTrackServiceGetByShorterDuration(){

    }
    @Test
    public void testTrackServiceGetByEqualDuration(){

    }
}

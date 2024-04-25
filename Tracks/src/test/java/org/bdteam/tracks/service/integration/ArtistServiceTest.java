package org.bdteam.tracks.service.integration;

import org.bdteam.tracks.domain.Artist;
import org.bdteam.tracks.service.ArtistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ArtistServiceTest {
    @Autowired
    private ArtistService artistService;

    @BeforeEach
    public void beforeEach(){}
    @Test
    public void testArtistServiceInsert(){
        Artist artist = new Artist();
        artist.setName("new");

        Artist insertedArtist = artistService.addArtist(artist);
        assertNotNull(insertedArtist);
        assertEquals(1, insertedArtist.getIdArtist());
    }

    @Test
    public void testArtistServiceGetById(){

    }

    @Test
    public void testArtistServiceUpdate(){

    }

    @Test
    public void testArtistServiceDelete(){

    }

    @Test
    public void testArtistServiceGetByName(){

    }
    @Test
    public void testArtistServiceGetAll(){

    }

    @Test
    public void testArtistServiceTrackOfArtist(){

    }
}

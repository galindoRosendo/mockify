package org.bdteam.tracks.provider;

import org.bdteam.tracks.domain.Track;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class NetworkPriceProvider implements PriceProvider{
    private String ratingUrl;
    private RestClient restClient;
    public NetworkPriceProvider(){
        var baseUrl = "http://localhost:8081";

        var rootUrl = "/price";
        ratingUrl = rootUrl + "/{id}";

        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Accept", "application/json")
                .defaultHeader("Content-Type", "application/json")
                .build();
    }
    @Override
    public void addPriceToTrack(Track track) {
        ResponseEntity<Double> response = restClient.get()
                .uri(ratingUrl, track.getIdTrack())
                .retrieve()
                .toEntity(Double.class);

        if(response.getStatusCode() == HttpStatus.OK) {
            Double price =  response.getBody();
            if(price != null) {
                track.setPrice(price);
            }
        }
    }
}

package org.bdteam.prices.controller;

import org.bdteam.prices.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price")
public class PricesController {
    @Autowired
    private PricesService pricesService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getPriceByTrackId(@PathVariable("id") int id){
        double result = pricesService.getPriceByTrackId(id);
        if (result == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No track with id: " + id);
        }
        return ResponseEntity.ok(result);
    }
}

package org.bdteam.prices.service;

import org.springframework.stereotype.Service;

@Service
public class PricesService {
    public double getPriceByTrackId(int id){
        Integer min = 1, max = 10;
        double price = min + Math.random() * (max - min);
        return price;
    }
}

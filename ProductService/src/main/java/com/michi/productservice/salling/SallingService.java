package com.michi.productservice.salling;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.michi.commons.FoodWasteProduct;
import com.michi.productservice.repository.FoodWasteProductRepository;
import com.michi.productservice.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;


@Service
@Log4j2
public class SallingService{

    private static final String BASE_URL = "https://api.sallinggroup.com";
    private static final String FOOD_WASTE_URL = "/v1/food-waste/1c7a633b-05dd-40d4-90d7-4cb8deb37db7";
    private static final String ISSUER_ID = "c6240b5c-a09d-4d53-90ce-189e5d6e41b8";
    private static final String SECRET = "17d7f837-9fff-446a-b1f7-b1a6adab10f0";

    FoodWasteProductRepository foodWasteProductRepository;

    public SallingService(FoodWasteProductRepository foodWasteProductRepository) {
        this.foodWasteProductRepository = foodWasteProductRepository;
    }

    @Scheduled(fixedRate = 60000*60)
    public void refreshFoodWasteData() {
        foodWasteProductRepository.saveAll(callSalling());
        log.info("Salling data refresh task completed");
    }

    public List<FoodWasteProduct> callSalling() {
        return WebClient.create(BASE_URL)
                .get()
                .uri(FOOD_WASTE_URL)
                .header("Authorization", "JWT " + generateJWT(FOOD_WASTE_URL))
                .retrieve().bodyToMono(Response.class)
                .map(Response::toProducts).block();
    }


    private String generateJWT(String path) {
        Algorithm algorithmHS = Algorithm.HMAC256(SECRET);
        return JWT.create()
                .withIssuer(ISSUER_ID)
                .withClaim("sub", path)
                .withClaim("mth", "GET")
                .withClaim("exp", System.currentTimeMillis() / 1000L)
                .sign(algorithmHS);
    }
}

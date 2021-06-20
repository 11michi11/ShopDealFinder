package com.michi.productservice.salling;

import com.michi.commons.FoodWasteProduct;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Response{
    public List<Clearance> clearances;
    public Store store;

    public List<FoodWasteProduct> toProducts() {
        return clearances.stream().map(Clearance::toProduct).collect(Collectors.toList());
    }

}

@Data
class Clearance{
    public Offer offer;
    public Product product;

    public FoodWasteProduct toProduct() {
        return new FoodWasteProduct(product.description, offer.newPrice, offer.discount, product.image);
    }

}

@Data
class Offer{
    public String currency;
    public int discount;
    public String ean;
    public Date endTime;
    public Date lastUpdate;
    public int newPrice;
    public int originalPrice;
    public double percentDiscount;
    public Date startTime;
    public int stock;

    public String stockUnit;


}
@Data
class Product{
    public String description;
    public String ean;
    public String image;

}

@Data
class Address{
    public String city;
    public String country;
    public String street;
    public String zip;
}

@Data
class Hour{
    public Date close;
    public boolean closed;
    public String date;
    public Date open;
    public String type;
    public List<Double> customerFlow;
}

@Data
class Store{
    public Address address;
    public String brand;
    public List<Double> coordinates;
    public List<Hour> hours;
    public String name;
    public String id;
    public String type;
}



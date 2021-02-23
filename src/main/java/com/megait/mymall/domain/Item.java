package com.megait.mymall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter @Getter
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    // name
    private String name;

    // price
    private int price;

    // stockQuantity
    private int stockQuantity;

    // categories
    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    // imageUrl
    private String imageUrl;

    // liked
    private int liked;
}

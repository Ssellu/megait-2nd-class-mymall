package com.megait.mymall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("G")
@Getter
@Setter
public class Game extends Item{
    private String title;
    private String publisher;
}
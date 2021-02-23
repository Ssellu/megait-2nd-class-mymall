package com.megait.mymall.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn
    private Member member;
/*
orderItems: List<OrderItem>
delivery : Delivery
orderDate : Date
status : Status
 */
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private Status status;

}

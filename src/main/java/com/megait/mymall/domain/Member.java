package com.megait.mymall.domain;

import lombok.*;



import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class Member {
    @Id @GeneratedValue
    private Long id;

    private String email;

    private String password;

    @Embedded  // 외부 Entity 를 내장하겠다.
    private Address address;

    private LocalDateTime joinedAt;

    private boolean emailVerified;

    private String emailCheckToken;

    @Enumerated(EnumType.STRING)
    private MemberType type;

    // 찜 목록
    @OneToMany  // Member : Item => 1 : N
    private List<Item> likes = new ArrayList<>();

    // 주문 내역
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}

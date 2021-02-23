package com.megait.mymall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    private Long id;

    private String name;

    // Category <--- 분류 ---> Item
    // 다대다 양방향
    // @JoinCulomn : Column 을 추가하겠다. 이건 Join할 때 쓸 것이다.
    // @JoinTable : Table 을 추가하겠다. 이건 Join 할 때 쓸 것이다.
    @ManyToMany
    @JoinTable(
       name = "category_item",
       joinColumns = @JoinColumn(name = "category_id"),
       inverseJoinColumns = @JoinColumn(name ="item_id")
    )
    private List<Item> items = new ArrayList<>();


    // Category(this) <--- 부모/자식 ---> Catergory(Parent)
    @ManyToOne(fetch=FetchType.LAZY)
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> children;

    public void addChildCategory(Category child){
        children.add(child);
        child.parent = this;
    }
}













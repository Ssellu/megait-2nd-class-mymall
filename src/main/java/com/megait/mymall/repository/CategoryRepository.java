package com.megait.mymall.repository;

import com.megait.mymall.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    public Category findByName(String name);
    public void deleteAllByName(String s);

    // 부모카테고리 + 카테고리명과 일치하는 카테고리 조회
    public Category findByNameAndParent(String name, Category parent);
}

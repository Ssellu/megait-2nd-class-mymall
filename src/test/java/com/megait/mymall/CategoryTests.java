package com.megait.mymall;

import com.megait.mymall.domain.Category;
import com.megait.mymall.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CategoryTests {

    @Autowired
    CategoryRepository categoryRepository;

    @PostConstruct
    void init(){
        Category category1 = new Category();
        category1.setName("테스트도서");

        Category category2 = new Category();
        category2.setName("테스트게임");

        Category category3 = new Category();
        category3.setName("테스트음반");

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
    }


    @Test
    void find_by_name_with_existing_entity(){
        // given
        String name = "wrong_name";

        // when
        Category category = categoryRepository.findByName(name);

        // then
        assertThat(category).isNull();
    }

    @Test
    void find_by_name_with_non_existing_entity(){
        // given
        String name = "테스트게임";

        // when
        Category category = categoryRepository.findByName(name);

        // then
        assertThat(category).isNotNull();
    }
}

package com.megait.mymall.service;

import com.megait.mymall.domain.Category;
import com.megait.mymall.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostConstruct
    private void addSampleCategories(){
        Category category1 = new Category();
        category1.setName("도서");

        Category category2 = new Category();
        category2.setName("게임");

        Category category3 = new Category();
        category3.setName("음반");

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        log.info("Category entities have been created.");
    }
}

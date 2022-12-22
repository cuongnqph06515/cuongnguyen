package com.migi.springapi.dao;

import com.migi.springapi.entity.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface CategoryJPA extends JpaRepository<Category, Integer> {
}

package com.example.salonofcars.repositories;

import com.example.salonofcars.models.Basket;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Integer> {
}

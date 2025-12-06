package com.example.library.specification;

import com.example.library.entity.Dealer;
import org.springframework.data.jpa.domain.Specification;

public class DealerSpecification {

    public static Specification<Dealer> addressContains(String keyword) {
        return (root, query, criteriaBuilder) -> {
            if (keyword == null || keyword.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("address")), "%" + keyword.toLowerCase() + "%");
        };
    }
}

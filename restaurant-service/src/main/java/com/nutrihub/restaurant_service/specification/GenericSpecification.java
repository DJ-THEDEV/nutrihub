package com.nutrihub.restaurant_service.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class GenericSpecification<T> {

    public Specification<T> likeIgnoreCase(String field, String value) {
        return (root, query, cb) ->
                value == null ? null :
                        cb.like(cb.lower(root.get(field)), "%" + value.toLowerCase() + "%");
    }

    public Specification<T> equal(String field, Object value) {
        return (root, query, cb) ->
                value == null ? null :
                        cb.equal(root.get(field), value);
    }

    public Specification<T> booleanEqual(String field, Boolean value) {
        return (root, query, cb) ->
                value == null ? null :
                        cb.equal(root.get(field), value);
    }
}

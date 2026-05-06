package com.juaracoding.pcmspringboot31.specification;

import com.juaracoding.pcmspringboot31.model.Menu;
import org.springframework.data.jpa.domain.Specification;
import java.time.LocalDate;
import java.time.LocalTime;

public class MenuSpecification {

    public static Specification<Menu> containsNamaMenu(String namaMenu) {
        return (root, query, criteriaBuilder)
                -> criteriaBuilder.like(criteriaBuilder.lower(root.get("nama")), "%" + namaMenu + "%");
    }
    public static Specification<Menu> containsPathMenu(String pathMenu) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("path")), "%" + pathMenu + "%");
    }
    public static Specification<Menu> containsDeskripsi(String deskripsiMenu) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("deskripsi")), "%" + deskripsiMenu + "%");
    }

    public static Specification<Menu> dateBetween(LocalDate start,LocalDate end) {
        // 1. Konversi 'start' ke awal hari (00:00:00)
        // 2. Konversi 'end' ke penghujung hari (23:59:59.999999999)
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("createdAt"), start.atStartOfDay(), end.atTime(LocalTime.MAX));
    }
}

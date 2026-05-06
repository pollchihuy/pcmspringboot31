package com.juaracoding.pcmspringboot31.repo;

import com.juaracoding.pcmspringboot31.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MenuRepo extends JpaRepository<Menu, Long>, JpaSpecificationExecutor<Menu> {

}
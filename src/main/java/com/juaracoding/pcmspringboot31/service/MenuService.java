package com.juaracoding.pcmspringboot31.service;

import com.juaracoding.pcmspringboot31.core.IFile;
import com.juaracoding.pcmspringboot31.core.IServiceDML;
import com.juaracoding.pcmspringboot31.core.IServiceQuery;
import com.juaracoding.pcmspringboot31.dto.query.SearchMenuDTO;
import com.juaracoding.pcmspringboot31.dto.validation.ValMenuDTO;
import com.juaracoding.pcmspringboot31.handler.ResponseHandler;
import com.juaracoding.pcmspringboot31.model.Menu;
import com.juaracoding.pcmspringboot31.repo.MenuRepo;
import com.juaracoding.pcmspringboot31.util.ConstantMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Modul Code : 02
 */
@Service
public class MenuService implements IServiceDML<Menu>, IServiceQuery<SearchMenuDTO>, IFile<Menu> {

    @Autowired
    private MenuRepo menuRepo;

    @Override
    public ResponseEntity<Object> save(Menu menu, HttpServletRequest request) {
        if(menu==null){
            return new ResponseHandler().
                    handleResponse(ConstantMessage.FAILED_SAVE, HttpStatus.BAD_REQUEST,null,"USM02001",request);
        }
        menu.setCreatedBy("{\"id\":\"1\",\"nama\":\"System\"}");
        menuRepo.save(menu);
        return new ResponseHandler().
                handleResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,request);
    }

    @Override
    public ResponseEntity<Object> update(Menu menu, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> deleteById(Long id, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findAll(Pageable pageable, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> findByParam(Pageable pageable, SearchMenuDTO param, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> upload(MultipartFile file, HttpServletRequest request) {
        return null;
    }

    @Override
    public void downloadExcel(Menu param, HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void downloadPdf(Menu param, HttpServletRequest request, HttpServletResponse response) {

    }
    public Menu mapToEntity(ValMenuDTO valMenuDTO){
        Menu menu = new Menu();
        menu.setNama(valMenuDTO.getNama());
        menu.setDeskripsi(valMenuDTO.getDeskripsi());
        menu.setPath(valMenuDTO.getPath());
        return menu;
    }
}
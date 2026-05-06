package com.juaracoding.pcmspringboot31.service;

import com.juaracoding.pcmspringboot31.core.IFile;
import com.juaracoding.pcmspringboot31.core.IServiceDML;
import com.juaracoding.pcmspringboot31.core.IServiceQuery;
import com.juaracoding.pcmspringboot31.dto.query.SearchAksesDTO;
import com.juaracoding.pcmspringboot31.dto.validation.ValAksesDTO;
import com.juaracoding.pcmspringboot31.handler.ResponseHandler;
import com.juaracoding.pcmspringboot31.model.Akses;
import com.juaracoding.pcmspringboot31.repo.AksesRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * project code : USM
 * modul code : 01
 */
@Service
@Transactional
public class AksesService implements IServiceDML<Akses>,
        IServiceQuery<SearchAksesDTO,Akses>, IFile<Akses> {

    @Autowired
    private AksesRepo aksesRepo;

    @Override
    public ResponseEntity<Object> save(Akses akses, HttpServletRequest request) {
        if(akses==null){
            return new ResponseHandler().
                    handleResponse("GAGAL DISIMPAN", HttpStatus.BAD_REQUEST,null,"USM01001",request);
        }
        aksesRepo.save(akses);
        return new ResponseHandler().
                handleResponse("BERHASIL DISIMPAN", HttpStatus.CREATED,null,null,request);
    }
    @Override
    public ResponseEntity<Object> update(Long id,Akses akses, HttpServletRequest request) {
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
    public ResponseEntity<Object> findByParam(Pageable pageable, SearchAksesDTO param, HttpServletRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Object> upload(MultipartFile file, HttpServletRequest request) {
        return null;
    }

    @Override
    public void downloadExcel(Akses param, HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void downloadPdf(Akses param, HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public Specification<Akses> getSpecification(SearchAksesDTO param) {
        return null;
    }

    public Akses mapToEntity(ValAksesDTO valAksesDTO){
        Akses akses = new Akses();
        akses.setNama(valAksesDTO.getNama());
        akses.setDeskripsi(valAksesDTO.getDeskripsi());
        return akses;
    }
}
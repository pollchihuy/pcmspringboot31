package com.juaracoding.pcmspringboot31.service;

import com.juaracoding.pcmspringboot31.core.IFile;
import com.juaracoding.pcmspringboot31.core.IServiceDML;
import com.juaracoding.pcmspringboot31.core.IServiceQuery;
import com.juaracoding.pcmspringboot31.dto.query.SearchMenuDTO;
import com.juaracoding.pcmspringboot31.dto.report.ReportMenuDTO;
import com.juaracoding.pcmspringboot31.dto.validation.ValMenuDTO;
import com.juaracoding.pcmspringboot31.handler.ResponseHandler;
import com.juaracoding.pcmspringboot31.model.Menu;
import com.juaracoding.pcmspringboot31.repo.MenuRepo;
import com.juaracoding.pcmspringboot31.specification.MenuSpecification;
import com.juaracoding.pcmspringboot31.util.ConstantMessage;
import com.juaracoding.pcmspringboot31.util.GlobalFunction;
import com.juaracoding.pcmspringboot31.util.TransformPagination;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.annotations.DynamicUpdate;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Modul Code : 02
 */
@Service
@Transactional
public class MenuService implements IServiceDML<Menu>, IServiceQuery<SearchMenuDTO,Menu>, IFile<SearchMenuDTO> {

    @Autowired
    private MenuRepo menuRepo;

    @Autowired
    private ModelMapper map;

    @Autowired
    private TransformPagination tp;

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

    @Override//011-020
    public ResponseEntity<Object> update(Long id,Menu menu, HttpServletRequest request) {
        if(menu==null){
            return new ResponseHandler().
                    handleResponse(ConstantMessage.FAILED_UPDATE, HttpStatus.BAD_REQUEST,null,"USM02011",request);
        }
        Optional<Menu> menuOptional = menuRepo.findById(id);
        if(menuOptional.isEmpty()){
            return new ResponseHandler().
                    handleResponse(ConstantMessage.NOT_FOUND, HttpStatus.NOT_FOUND,null,"USM02012",request);
        }

        /** dirty checking
         * UPDATE MstMenu SET nama = 'menu.getNama()',
         * deskripsi = 'menu.getDeskripsi()',
         * path = 'menu.getPath()',
         * updated_by = '{"id":"1","nama":"System"}' WHERE id = 'id'
         * */
            Menu menuDB = menuOptional.get();
            if(menuDB.getDeletedBy()!=null){
                return new ResponseHandler().
                        handleResponse(ConstantMessage.NOT_FOUND, HttpStatus.NOT_FOUND,null,"USM02013",request);
            }
            menuDB.setNama(menu.getNama());//akses -> akses
            menuDB.setDeskripsi(menu.getDeskripsi());
            menuDB.setPath(menu.getPath());
            menuDB.setUpdatedBy("{\"id\":\"1\",\"nama\":\"System\"}");
        return new ResponseHandler().
                handleResponse(ConstantMessage.SUCCESS_UPDATE, HttpStatus.OK,null,null,request);
    }

    @Override
    public ResponseEntity<Object> deleteById(Long id, HttpServletRequest request) {
        if(id==null){
            return new ResponseHandler().
                    handleResponse(ConstantMessage.FAILED_DELETE, HttpStatus.BAD_REQUEST,null,"USM02021",request);
        }
        Optional<Menu> menuOptional = menuRepo.findById(id);
        if(menuOptional.isEmpty()){
            return new ResponseHandler().
                    handleResponse(ConstantMessage.NOT_FOUND, HttpStatus.NOT_FOUND,null,"USM02022",request);
        }
        Menu menuDB = menuOptional.get();
        if(menuDB.getDeletedBy()!=null){
            return new ResponseHandler().
                    handleResponse(ConstantMessage.NOT_FOUND, HttpStatus.NOT_FOUND,null,"USM02023",request);
        }
        menuDB.setDeletedBy("{\"id\":\"1\",\"nama\":\"System\"}");
        menuDB.setDeletedAt(LocalDateTime.now());
        return new ResponseHandler().
                handleResponse(ConstantMessage.SUCCESS_DELETE, HttpStatus.OK,null,null,request);
    }

    @Override
    public ResponseEntity<Object> findAll(Pageable pageable, HttpServletRequest request) {
        Page<Menu> page = menuRepo.findAll(pageable);
        if(page.isEmpty()){
            return new ResponseHandler().
                    handleResponse(ConstantMessage.NOT_FOUND, HttpStatus.NOT_FOUND,null,"USM02151",request);
        }

        return new ResponseHandler().
                handleResponse(ConstantMessage.OK, HttpStatus.OK,
                tp.transformPagination(mapperToDTO(page.getContent()),page,new SearchMenuDTO()),
                null,request);
    }

    @Override
    public ResponseEntity<Object> findByParam(Pageable pageable, SearchMenuDTO param, HttpServletRequest request) {
        Page<Menu> page = null;
        if(param==null){
            page = menuRepo.findAll(pageable);
            return new ResponseHandler().
                    handleResponse(ConstantMessage.OK, HttpStatus.OK,
                            tp.transformPagination(mapperToDTO(page.getContent()),page,param),"USM02161",request);
        }
        page = menuRepo.findAll(getSpecification(param), pageable);
        if(page.isEmpty()){
            return new ResponseHandler().
                    handleResponse(ConstantMessage.NOT_FOUND, HttpStatus.NOT_FOUND,null,"USM02162",request);
        }
        return new ResponseHandler().
                handleResponse(ConstantMessage.OK, HttpStatus.OK,tp.transformPagination(mapperToDTO(page.getContent()),page,param),null,request);
    }

    @Override
    public ResponseEntity<Object> upload(MultipartFile file, HttpServletRequest request) {
        return null;
    }

    @Override
    public void downloadExcel(SearchMenuDTO param, HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    public void downloadPdf(SearchMenuDTO param, HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public Specification<Menu> getSpecification(SearchMenuDTO param){
        // 1. Inisialisasi dasar: SELECT * FROM User WHERE 1=1
        // (Wadah kosong yang tidak memfilter apa-apa)
        Specification<Menu> spec = Specification.where(null);

        //SELECT * FROM User WHERE 1=1 OR lower(nama) like lower(concat('%',?,'%'))
        if(GlobalFunction.checkFilter(param.getNama())){
            spec = spec.or(MenuSpecification.containsNamaMenu(param.getNama()));
        }
        //SELECT * FROM User WHERE 1=1 OR lower(nama) like lower(concat('%',?,'%')) OR lower(path) like lower(concat('%',?,'%'))
        if(GlobalFunction.checkFilter(param.getPath())){
            spec = spec.or(MenuSpecification.containsPathMenu(param.getPath()));
        }
        //SELECT * FROM User WHERE 1=1 OR lower(nama) like lower(concat('%',?,'%')) OR lower(path) like lower(concat('%',?,'%')) OR lower(deskripsi) like lower(concat('%',?,'%'))
        if(GlobalFunction.checkFilter(param.getDeskripsi())){
            spec = spec.or(MenuSpecification.containsPathMenu(param.getDeskripsi()));
        }
        //SELECT * FROM User WHERE 1=1 OR lower(nama) like lower(concat('%',?,'%')) OR lower(path) like lower(concat('%',?,'%')) OR lower(deskripsi) like lower(concat('%',?,'%')) AND createdAt BETWEEN start and end
        if(GlobalFunction.checkFilter(param.getStart()) && GlobalFunction.checkFilter(param.getEnd())){
            spec = spec.and(MenuSpecification.dateBetween(param.getStart(), param.getEnd()));
        }
        return spec;
    }
    public Menu mapToEntity(ValMenuDTO valMenuDTO){
        Menu menu = new Menu();
        menu.setNama(valMenuDTO.getNama());
        menu.setDeskripsi(valMenuDTO.getDeskripsi());
        menu.setPath(valMenuDTO.getPath());
        return menu;
    }
    public Menu mapperToEntity(ValMenuDTO valMenuDTO){
        Menu menu = map.map(valMenuDTO, Menu.class);
        return menu;
    }
    public List<ReportMenuDTO> mapperToDTO(List<Menu> menus){
        List<ReportMenuDTO> menu = map.map(menus, new TypeToken<List<ReportMenuDTO>>() {}.getType());
        return menu;
    }
}
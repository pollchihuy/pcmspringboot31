package com.juaracoding.pcmspringboot31.core;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * 001-150
 * @param <T>
 */
public interface IServiceDML<T> {
    public ResponseEntity<Object> save(T t,HttpServletRequest request);//001-010
    public ResponseEntity<Object> update(Long id,T t,HttpServletRequest request);//011-020
    public ResponseEntity<Object> deleteById(Long id,HttpServletRequest request);//021-030
    //AUTH05312
}
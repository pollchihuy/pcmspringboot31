package com.juaracoding.pcmspringboot31.service;

import com.juaracoding.pcmspringboot31.dto.validation.LoginDTO;
import com.juaracoding.pcmspringboot31.dto.validation.RegisDTO;
import com.juaracoding.pcmspringboot31.handler.ResponseHandler;
import com.juaracoding.pcmspringboot31.model.User;
import com.juaracoding.pcmspringboot31.repo.UserRepo;
import com.juaracoding.pcmspringboot31.util.ConstantMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * modul code : 00
 */
@Service
@Transactional
public class AuthService implements UserDetailsService {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper ;
    /**
     * Login
     * Regis
     * Lupa Password
     */

    public ResponseEntity<Object> regis(User user, HttpServletRequest request){
        if(user==null){
            return new ResponseHandler().
                    handleResponse(ConstantMessage.FAILED_REGIS, HttpStatus.BAD_REQUEST,null,"USM00001",request);
        }
    /**
     *
     */
        userRepo.save(user);
        return new ResponseHandler().
                handleResponse(ConstantMessage.SUCCESS_SAVE, HttpStatus.CREATED,null,null,request);
    }

    /**
     * method ini digunakan untuk validasi username dari token jwt
     * @param username the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepo.findByUsername(username);
        if(userOptional.isEmpty()){
            throw new UsernameNotFoundException("User Tidak Ditemukan");
        }
        User user = userOptional.get();
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.getAuthorities());
    }

    public User mapToEntity(RegisDTO regisDTO){
        return modelMapper.map(regisDTO,User.class);
    }
    public User mapToEntity(LoginDTO loginDTO){
        return modelMapper.map(loginDTO,User.class);
    }
}
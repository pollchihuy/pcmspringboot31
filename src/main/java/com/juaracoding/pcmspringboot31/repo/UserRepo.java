package com.juaracoding.pcmspringboot31.repo;

import com.juaracoding.pcmspringboot31.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    /** DERIVED QUERY */
    /** SELECT * FROM MstUser WHERE username = ? */
    public Optional<User> findByUsername(String username);
    public Optional<User> findByEmail(String z);
    public Optional<User> findByNoHp(String y);

    /** SELECT * FROM MstUser WHERE username = ? OR email = ? OR noHp = ?*/
    public Optional<User> findByUsernameOrEmailOrNoHp(String username, String email, String noHp);

    @Query("SELECT u FROM User u JOIN FETCH u.akses a JOIN FETCH a.aksesMenuList WHERE u.username = :username")
    Optional<User> findByUsernameWithAkses(@Param("username") String username);
}
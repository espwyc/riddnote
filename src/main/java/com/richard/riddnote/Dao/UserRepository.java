package com.richard.riddnote.Dao;


import com.richard.riddnote.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

    User findByUid(String uid);
    User findByUname(String uname);
}

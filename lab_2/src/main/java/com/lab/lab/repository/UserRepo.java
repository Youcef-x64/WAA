package com.lab.lab.repository;

import com.lab.lab.entity.User_;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User_,Long> {

    @Query("SELECT u FROM User_ u WHERE u.posts.size > 1")
    List<User_> findUsersByPostsGreaterThan();

}

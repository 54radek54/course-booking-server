package com.example.coursebookingserver.repository;

import com.example.coursebookingserver.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByEmail(String Email);

    AppUser findUserById(Long userId);

    List<AppUser> findAll();

    @Query("select a from AppUser a where a.email like %:keyword% or a.firstName like %:keyword% or a.role like %:keyword%")
    List<AppUser> findUserByKeyword(@Param("keyword") String keyword);
}

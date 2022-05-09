package com.example.coursebookingserver.service;

import com.example.coursebookingserver.exception.AppBasicException;
import com.example.coursebookingserver.model.AppUser;

import java.security.Principal;
import java.util.List;

public interface AppUserService {

    void addUser(AppUser appUser)throws AppBasicException;

    List<AppUser> getAllUserAccounts();

    void editUser(AppUser appUser, Principal principal)throws AppBasicException;

    void deleteUserById(Long id)throws AppBasicException;

    void makeEmployeeFromUserById(Long id)throws AppBasicException;

    AppUser getAppUserByEmail(String email)throws AppBasicException;

    List<AppUser> getByKeyword(String keyword);

}

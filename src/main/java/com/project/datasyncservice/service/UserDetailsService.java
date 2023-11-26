package com.project.datasyncservice.service;


import com.project.datasyncservice.dto.UserDetailDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserDetailsService {

    UserDetailDTO findNonFRUser(String mobileNumber);

    UserDetailDTO handleNewNonFRUserRegistration(String mobileNumber);

    UserDetailDTO saveUserData(UserDetailDTO userDetailDTO);
}

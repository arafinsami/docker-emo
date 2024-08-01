package com.docker.service;

import com.docker.entity.AppUser;
import com.docker.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;

    @Transactional(readOnly = true)
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }
}

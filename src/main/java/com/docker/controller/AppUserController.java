package com.docker.controller;

import com.docker.dto.AppUserDTO;
import com.docker.entity.AppUser;
import com.docker.service.AppUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "Employee Query API")
@RequestMapping(path = "/users")
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping
    @Operation(summary = "find all users")
    public ResponseEntity<List<AppUserDTO>> findAll() {
        List<AppUser> users = appUserService.findAll();
        List<AppUserDTO> responseDTOS = users.stream()
                .map(employee ->
                        AppUserDTO.builder()
                                .id(employee.getId())
                                .firstName(employee.getFirstName())
                                .lastName(employee.getLastName())
                                .email(employee.getEmail())
                                .build())
                .collect(Collectors.toList());
        return new ResponseEntity<>(responseDTOS, HttpStatus.OK);
    }
}

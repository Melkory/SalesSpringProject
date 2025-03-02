package com.dziombra.dscommerce.controllers;

import com.dziombra.dscommerce.dto.ProductDTO;
import com.dziombra.dscommerce.dto.UserDTO;
import com.dziombra.dscommerce.entities.User;
import com.dziombra.dscommerce.services.ProductService;
import com.dziombra.dscommerce.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CLIENT')")
    @GetMapping(value = "/me")
    public ResponseEntity<UserDTO> findMe() {
        UserDTO dto = service.getMe();
        return ResponseEntity.ok(dto);
    }

}

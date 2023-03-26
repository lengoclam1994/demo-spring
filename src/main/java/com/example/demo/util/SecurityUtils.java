package com.example.demo.util;

import com.example.demo.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static User getPrincipal() {
        return (User) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}

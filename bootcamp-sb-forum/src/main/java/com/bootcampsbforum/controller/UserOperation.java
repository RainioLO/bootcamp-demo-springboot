package com.bootcampsbforum.controller;

import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcampsbforum.infra.ApiResp;
import com.bootcampsbforum.model.dto.jph.User;

public interface UserOperation {

        @GetMapping(value = "/users")
        List<User> getUsers();

        @GetMapping(value = "/users/count")
        @ResponseStatus(value = HttpStatus.OK)
        ApiResp<Long> countUserByName(
                        @RequestParam(value = "prefix") String prefix);

        @GetMapping(value = "/users/lat/{lat}")
        @ResponseStatus(value = HttpStatus.OK)
        ApiResp<List<com.bootcampsbforum.entity.User>> getUsersByLatGreaterThan(
                        @PathVariable(value = "lat") String latitude);

        @GetMapping(value = "/users/email/{email}/phone/{phone}")
        @ResponseStatus(value = HttpStatus.OK)
        ApiResp<List<com.bootcampsbforum.entity.User>> getUsersByEmailAndPhone(
                        @PathVariable String email, @PathVariable String phone);

        @GetMapping(value = "/user/username/{username}")
        @ResponseStatus(value = HttpStatus.OK)
        ApiResp<com.bootcampsbforum.entity.User> findByUsername(
                        @PathVariable String username);

        @GetMapping(value = "/user/{id}/{email}")
        @ResponseStatus(value = HttpStatus.OK)
        ApiResp<Void> updateUserEmailById(@PathVariable Long id,
                        @PathVariable String email);

        @PutMapping(value = "/user/id/{userId}")
        @ResponseStatus(value = HttpStatus.OK)
        ApiResp<com.bootcampsbforum.entity.User> updateUser(
                        @PathVariable Long userId,
                        @RequestBody com.bootcampsbforum.entity.User user);

}

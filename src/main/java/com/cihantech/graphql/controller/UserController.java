package com.cihantech.graphql.controller;

import com.cihantech.graphql.model.User;
import com.cihantech.graphql.model.UserRequest;
import com.cihantech.graphql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @QueryMapping
    List<User> getAllUsers(){
        return  userService.getAllUsers();
    }
    @QueryMapping
    User getUserById(@Argument Long id){
        return  userService.getUserById(id);
    }

    @MutationMapping
    User createUser(@Argument UserRequest userRequest){
        return  userService.createUser(userRequest);
    }
    @MutationMapping
    User updateUser(@Argument UserRequest userRequest){
        return  userService.updateUser(userRequest);
    }
    @MutationMapping
    Boolean deleteUser(@Argument Long id){
        userService.deleteUser(id);
        return true;
    }

}

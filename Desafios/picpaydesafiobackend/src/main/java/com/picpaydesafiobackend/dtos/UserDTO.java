package com.picpaydesafiobackend.dtos;

import com.picpaydesafiobackend.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String document, BigDecimal balance,String email, String password, UserType userType)
{ }

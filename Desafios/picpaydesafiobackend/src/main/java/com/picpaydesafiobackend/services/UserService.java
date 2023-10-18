package com.picpaydesafiobackend.services;

import com.picpaydesafiobackend.domain.user.User;
import com.picpaydesafiobackend.domain.user.UserType;
import com.picpaydesafiobackend.dtos.UserDTO;
import com.picpaydesafiobackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception
    {
        if(sender.getUserType() == UserType.SHOPKEEPER)
        {
            throw new Exception("Shopkeepers can't send money");
        }

        if(sender.getBalance().compareTo(amount) < 0)
        {
            throw new Exception("Insufficient funds");
        }
    }

    public User findUserById(Long id) throws Exception
    {
        return userRepository.findById(id).orElseThrow(() -> new Exception("User not found"));
    }

    public User createUser(UserDTO userDTO)
    {
        User user = new User(userDTO);
        userRepository.save(user);

        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user)
    {
        userRepository.save(user);
    }

}

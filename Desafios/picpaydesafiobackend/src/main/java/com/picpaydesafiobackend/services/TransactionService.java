package com.picpaydesafiobackend.services;

import com.picpaydesafiobackend.domain.transaction.Transaction;
import com.picpaydesafiobackend.domain.user.User;
import com.picpaydesafiobackend.dtos.TransactionDTO;
import com.picpaydesafiobackend.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;
import java.math.BigDecimal;

@Service
public class TransactionService
{
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotificationService notificationService;

    public Transaction createTransaction(TransactionDTO transactionDTO) throws Exception
    {
        User sender = userService.findUserById(transactionDTO.senderId());
        User receiver = userService.findUserById(transactionDTO.receiverId());

        userService.validateTransaction(sender, transactionDTO.value());

        Boolean transactionAuthorized = authorizeTransaction(sender, transactionDTO.value());
        if(!transactionAuthorized)
        {
            throw new Exception("Transaction not authorized");
        }

        Transaction transaction = new Transaction();
        transaction.setSender(sender);
        transaction.setReceiver(receiver);
        transaction.setAnount(transactionDTO.value());
        transaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transactionDTO.value()));
        receiver.setBalance(receiver.getBalance().add(transactionDTO.value()));

        transactionRepository.save(transaction);
        userService.saveUser(sender);
        userService.saveUser(receiver);

        // notificationService.sendNotification(sender, "You sent " + transactionDTO.value() + " to " + receiver.getFirstName());
        // notificationService.sendNotification(receiver, "You received " + transactionDTO.value() + " from " + sender.getFirstName());

        return transaction;
    }

    public boolean authorizeTransaction(User sender, BigDecimal amount)
    {
        Random random = new Random();
        int randomNumber = random.nextInt(100);

        String url;
        if (randomNumber < 70)  // 70% de chance de escolher url1
        {
            url = "https://run.mocky.io/v3/3e065245-73ff-4cca-8da2-9ab96a4831c4";
        }
        else
        {
            url = "https://run.mocky.io/v3/f4e90aff-0fe3-466d-a7e6-a3414340fc73";
        }


        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        if (response.getStatusCode() == HttpStatus.OK)
        {
            String message = (String) response.getBody().get("message");
            return "Authorized".equalsIgnoreCase(message);
        }else return false;
    }
}

package com.picpaydesafiobackend.services;

import com.picpaydesafiobackend.domain.user.User;
import com.picpaydesafiobackend.dtos.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService
{
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception
    {
        String email = user.getEmail();

        NotificationDTO notificationRequest = new NotificationDTO(email, message);

        String url = "http://o4d9z.mocklab.io/notify";

        ResponseEntity<String> response = restTemplate.postForEntity(url, notificationRequest, String.class);

        if(!(response.getStatusCode() == HttpStatus.OK))
        {
            System.out.println("Error sending notification");

            throw new Exception("Error sending notification");
        }

    }


}

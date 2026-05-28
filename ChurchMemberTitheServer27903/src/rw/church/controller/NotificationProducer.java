/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.church.controller;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;

/**
 *
 * @author nshut
 */
public class NotificationProducer {

    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String QUEUE_NAME = "ChurchNotifications";

    public static void sendNotification(String message) {
        try {
            ActiveMQConnectionFactory factory =
                new ActiveMQConnectionFactory(BROKER_URL);
            Connection connection = factory.createConnection();
            connection.start();
            Session session = connection.createSession(false,
                Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(QUEUE_NAME);
            MessageProducer producer = session.createProducer(destination);
            TextMessage textMessage = session.createTextMessage(message);
            producer.send(textMessage);
            System.out.println("Notification sent: " + message);
            session.close();
            connection.close();
        } catch (Exception ex) {
            System.out.println("Notification (offline): " + message);
        }
    }
}

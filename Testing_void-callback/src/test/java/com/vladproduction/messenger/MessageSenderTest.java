package com.vladproduction.messenger;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MessageSenderTest {

    @Test
    public void testSendMessage() {
        // Create a mock of the Messenger interface
        Messenger messenger = mock(Messenger.class);

        // Create an instance of the MessageSender with the messenger
        MessageSender messageSender = new MessageSender(messenger);

        // Define the message to send
        String message = "Hello, World!";

        // Call the sendMessage method
        messageSender.sendMessage(message);

        //todo from here (start/run???)
        doNothing().when(messenger).send(message); //if we are not interesting of result

        // Verify that the send method on the messenger was called with the expected message
        verify(messenger).send(message); //have to return result of executing, so instead start --> run()

    }

}
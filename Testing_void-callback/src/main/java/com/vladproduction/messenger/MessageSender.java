package com.vladproduction.messenger;

public class MessageSender {
    private Messenger messenger;

    public MessageSender(Messenger messenger) {
        this.messenger = messenger;
    }

    public void sendMessage(final String message) {
        Runnable sendTask = () -> messenger.send(message);
        //new Thread(sendTask).start();
        new Thread(sendTask).run();
    }

}



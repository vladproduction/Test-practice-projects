package com.vladproduction.lection_material;

public class EmailServiceImpl implements EmailService {
    @Override
    public void sendEmail(String email) {
//        if(email.contains("test")){
//            //don`t send email
//            return;
//        }
//        if(email.startsWith("salary")){
//            //send email
//            System.out.println(email);
//        }
        sendEmail(email, null, null);
    }

    //overload method
    public void sendEmail(String email, Runnable callback1, Runnable callback2){
        if(email.contains("test")){
            if(callback1 != null){
                callback1.run();
            }
            //don`t send email  //we don`t have any sout here as simulating
            return;
        }
        if (email.startsWith("salary")){
            if(callback2 != null){
                callback2.run();
            }
            //send email
            System.out.println(email);
        }
    }
}

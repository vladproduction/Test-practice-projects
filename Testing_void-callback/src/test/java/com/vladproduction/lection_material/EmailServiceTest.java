package com.vladproduction.lection_material;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class EmailServiceTest {

    @Test
    public void dontSendEmail(){
        EmailServiceImpl emailService = new EmailServiceImpl();
        Runnable runnable1 = mock(Runnable.class);
        Runnable runnable2 = mock(Runnable.class);
        emailService.sendEmail("test", runnable1, runnable2);
        verify(runnable1, times(1)).run();
        verify(runnable2, never()).run();
    }

    @Test
    public void sendEmail(){
        EmailServiceImpl emailService = new EmailServiceImpl();
        Runnable runnable1 = mock(Runnable.class);
        Runnable runnable2 = mock(Runnable.class);
        emailService.sendEmail("salary", runnable1, runnable2);
        verify(runnable1, never()).run();
        verify(runnable2, times(1)).run();
    }

    @Test
    public void sendEmailCase3(){
        EmailServiceImpl emailService = new EmailServiceImpl();
        Runnable runnable1 = mock(Runnable.class);
        Runnable runnable2 = mock(Runnable.class);
        emailService.sendEmail("salary test", runnable1, runnable2);
        verify(runnable1, times(1)).run();
        verify(runnable2, never()).run();
    }

    @Test
    public void sendEmailCase4(){
        EmailServiceImpl emailService = new EmailServiceImpl();
        Runnable runnable1 = mock(Runnable.class);
        Runnable runnable2 = mock(Runnable.class);
        emailService.sendEmail("test salary", runnable1, runnable2);
        verify(runnable1, times(1)).run();
        verify(runnable2, never()).run();
    }

    @Test
    public void sendEmailCase5(){
        EmailServiceImpl emailService = new EmailServiceImpl();
        Runnable runnable1 = mock(Runnable.class);
        Runnable runnable2 = mock(Runnable.class);
        emailService.sendEmail("BIG salary", runnable1, runnable2);
        //verify(runnable1, times(1)).run();
        verify(runnable1, never()).run();
        verify(runnable2, never()).run();
    }
}

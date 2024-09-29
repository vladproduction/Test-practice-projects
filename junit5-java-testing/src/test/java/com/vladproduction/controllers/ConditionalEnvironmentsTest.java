package com.vladproduction.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class ConditionalEnvironmentsTest {

    @EnabledOnOs(OS.MAC)
    @Test
    public void testMeOnMacOS(){

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    public void testMeOnWindows(){

    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    public void testMeOnJava8(){

    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    public void testMeOnJava11(){

    }

    @EnabledOnJre(JRE.OTHER)
    @Test
    public void testMeOnJava17(){

    }

    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "admin")
    @Test
    public void testIfUserAdmin() {

    }

}

package com.example.hospitalfinder;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

import com.example.hospitalfinder.activity.LoginActivity;
import org.junit.Test;

public class LoginActivityTest {

    @Test
    public void loginActivity_CorrectClassName() {
        assertEquals(LoginActivity.class.getName(),"com.example.hospitalfinder.activity.LoginActivity");
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionWithException() {
        int i = 1 / 0;
    }

    @Test
    public void testAppNameInit() {
        if(R.string.app_name != 0)
        {
            //Return true
            assertEquals(0, 0);
        }
        else
        {
            //Return false
            assertEquals(0, 1);
        }

    }
}
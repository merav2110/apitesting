package com.testing.merav.tests;

import org.testng.annotations.Test;

public class DeleteUser {


    @Test
    public void successDelete(){

        //test input
        String username="tomer";
        String password = "1234";

        //response example
        /*
        {
            "username": "tomer",
            "token": "d372b4ec15cd46ffb1e6da83bbb5309b"
        }
         */



    }

    @Test
    public void failedDeleteWrongToken(){

    }

    @Test
    public void failedDeleteNoToken(){

    }

    @Test
    public void failedDeleteCorruptedToken(){

    }

    @Test
    public void failedDeleteNoSuchUser(){

    }

    @Test
    public void failedDeleteUserNotLogin(){

    }


}

package com.testing.merav.infra;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {

    private int success=200;
    private int userAdded=201;
    private int fail=406;
    private int wrongPassword=401;
    private int userDoesntExist=401;

    public int getFail() {
        return fail;
    }
    public int getUserAdded() {
        return userAdded;
    }

    public int getUserDoesntExist() {
        return userDoesntExist;
    }

    public int getSuccess() {
        return success;
    }
    public int getWrongPassword() {
        return wrongPassword;
    }
}

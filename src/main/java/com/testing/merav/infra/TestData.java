package com.testing.merav.infra;

public class TestData {

    private String restAPI = "http://payoneerInterview.pythonanywhere.com";

    public String getRestAPI() {
        return restAPI;
    }


    //Potentially I could please the data for the test in this class or data provider class
    //it shouldn't be inside the test itself
}

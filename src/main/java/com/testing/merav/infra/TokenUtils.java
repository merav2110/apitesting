package com.testing.merav.infra;

import java.io.IOException;

public interface TokenUtils {

    //for testing purposes we will save the token that we get and we will use them in the tests
    void saveToken(String userName, String token)throws IOException;
    String getToken(String userName);
    Boolean deleteToken(String userName);
}

package com.testing.merav.infra;

import com.testing.merav.tests.CreateUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TokenUtilsImpl implements TokenUtils {
    final private static Logger LOGGER = LoggerFactory.getLogger(CreateUser.class.getName());

    File targetFile;

    public void saveToken(String userName, String token) throws IOException {

        //open a folder to save results
        StringBuilder filePathBuilder = new StringBuilder();
        filePathBuilder.append(System.getProperty("user.dir"));
        filePathBuilder.append(File.pathSeparatorChar);
        filePathBuilder.append(userName);
        filePathBuilder.append(".txt");

        targetFile = new File(filePathBuilder.toString());
        if (targetFile.exists()){
            LOGGER.info("deleting previous token");
            Boolean delete = targetFile.delete();
            if(delete){
                try {
                    targetFile.createNewFile();
                } catch (IOException e) {
                    LOGGER.error("Exception file exist check for potential problem:"+e.getStackTrace());
                }
            }
        }
        else{
            try {
                targetFile.createNewFile();
            } catch (IOException e) {
                LOGGER.error("Exception can't create file:"+e.getStackTrace());
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile));
        try {
            writer.write(token);
        } catch (IOException e) {
            LOGGER.error("Exception can't write :"+e.getStackTrace());;
        }

        writer.close();
    }

    public String getToken(String userName) {
        return null;
    }

    public Boolean deleteToken(String userName) {
        return null;
    }
}

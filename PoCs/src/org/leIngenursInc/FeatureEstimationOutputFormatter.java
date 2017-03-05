package org.leIngenursInc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by blackShadow on 11/6/2016.
 */
public class FeatureEstimationOutputFormatter {
    private static final String DIR_PATH = "E:\\repos\\combinedDAGOrder\\sampledBNs\\";
    private static final String[] ARR_FILES = new String[] {
            "data5nodes\\data5nodes_mix_m4_ad0.txt",
            "asia\\asia_mix_m4_ad0.txt",
            "sachs\\sachs_mix_m4_ad0.txt"
    };

    public static void main(String[] args) {
        for(String filePath : ARR_FILES) {
            StringBuilder stringBuilder = new StringBuilder(readFileAsString(DIR_PATH +filePath));
            for (int index = 0; index < stringBuilder.length() - 1; index++) {
                if (stringBuilder.charAt(index) == '-' && stringBuilder.charAt(index + 1) == '>') {
                    stringBuilder.replace(index, index + 2, " ");
                }
            }
            System.out.println(stringBuilder.toString());
            writeStringToFile(stringBuilder.toString(), DIR_PATH +filePath);
        }
    }

    private static void writeStringToFile(String data, String filePath) {
        if(data== null) {
            return;
        }
        try(FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(data.getBytes());
        } catch(Exception exc) {
            exc.printStackTrace();
        }
    }

    private static String readFileAsString(String filePath) {
        try(InputStream inputStream = new FileInputStream(filePath)) {
            byte[] arrBytes = new byte[inputStream.available()];
            inputStream.read(arrBytes);
            return new String(arrBytes);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
}

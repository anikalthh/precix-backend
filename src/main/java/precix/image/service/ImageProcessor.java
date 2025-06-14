package precix.image.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service
public class ImageProcessor {
    
    public void processImage(String fileName, String imgProcessType) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("python3", "data_processing_sample/main.py", fileName, String.format("--%s", imgProcessType));
        pb.redirectErrorStream(true);
        System.out.println("process Image");

        try {
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            int exitCode = process.waitFor();
            System.out.println("Python script exited with code: " + exitCode);
        } catch (Exception e) {
            System.out.println("processImage error: " + e);
            e.printStackTrace();
        }
    }
    
}

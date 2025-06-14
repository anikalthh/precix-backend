package precix.image.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import precix.image.service.ImageProcessor;
import precix.image.service.ImageService;

@CrossOrigin(origins = "*")
@Controller
public class ImageController {

    @Autowired
    private ImageService imgSvc;

    @Autowired
    private ImageProcessor imgProcessor;

    @PostMapping(path="/imageupload", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> handleUpload(@RequestParam("image") MultipartFile file, @RequestParam("imageProcessType") String imgProcessType) throws Exception {
        String saved = imgSvc.saveToFile(file, file.getOriginalFilename());
        System.out.print("saving file" + file.getOriginalFilename());
        imgProcessor.processImage(saved, imgProcessType);

        return ResponseEntity.ok(file.getOriginalFilename());
    }
}
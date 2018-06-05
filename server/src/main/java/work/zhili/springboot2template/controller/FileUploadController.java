package work.zhili.springboot2template.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Title : work.zhili.springboot2template.controller <br>
 * Description : <br>
 *   file upload examples
 *
 * @author chile
 * @version 1.0
 * @date 2018/5/29 18:00
 */
@RestController
@RequestMapping("/api/v1/files")
public class FileUploadController {

    @PostMapping
    public Object uploadFile(MultipartFile file) {

        System.out.println(file.getOriginalFilename());

        return ResponseEntity.ok("OK");
    }

}

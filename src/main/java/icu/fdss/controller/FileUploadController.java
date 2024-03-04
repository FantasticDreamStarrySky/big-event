package icu.fdss.controller;

import icu.fdss.entity.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传
 *
 * @author 🌃梦幻◎星空🌃
 * @apiNote 处理文件上传相关的操作和逻辑控制。提供文件上传功能，包括文件上传。
 */
@RestController
public class FileUploadController {

    /**
     * 文件上传
     *
     * @param file 文件
     * @return {@link Result}<{@link String}> 文件的URL访问地址
     * @throws IOException IO异常
     */
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        // 把文件的内容存储到本地磁盘上
        String originalFilename = file.getOriginalFilename();
        // 保证文件的名字是唯一的，从而避免文件的覆盖
        String fileName = null;
        if (originalFilename != null) {
            fileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        file.transferTo(new File("D:\\upload\\" + fileName));
        return Result.success("URL访问地址");
    }

}

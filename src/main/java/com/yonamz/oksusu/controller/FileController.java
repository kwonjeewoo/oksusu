package com.yonamz.oksusu.controller;

import com.yonamz.oksusu.domain.Files;
import com.yonamz.oksusu.repository.FilesRepository;
import com.yonamz.oksusu.service.FilesService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class FileController {
    @Autowired
    FilesService filesService;

    @GetMapping("/files/insert")
    public String Insert(){
        return "/files/insert";
    }

    @PostMapping("/files/insert")
    public String fileInsert(
            HttpServletRequest request, @RequestParam MultipartFile files)
            throws Exception {
        Files file = new Files();

        String sourceFileName = file.getFileName();
        File destinationFile;
        String destinationFileName;
        String fileUrl = "C:/spring/oksusu/src/main/resources/static/images/";

        do{
            destinationFileName = RandomStringUtils.randomAlphanumeric(32);
            destinationFile = new File(fileUrl + destinationFileName);
        } while (destinationFile.exists());

        destinationFile.getParentFile().mkdirs();
        files.transferTo(destinationFile);

        file.setFileName(destinationFileName);
        file.setFileUrl(fileUrl);
        filesService.save(file);
        return "redirect:/files/detailPic";
    }

    @RequestMapping("/files/detailPic")
    public String detailPic(Model model) {
        model.addAttribute("file", filesService.findByFno(3));
        return "files/detailPic";
    }

}

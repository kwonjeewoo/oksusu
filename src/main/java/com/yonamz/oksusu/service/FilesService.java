package com.yonamz.oksusu.service;

import com.yonamz.oksusu.domain.Files;
import com.yonamz.oksusu.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilesService {
    @Autowired
    FilesRepository filesRepository;

    public void save(Files files) {
        Files file = new Files();
        file.setFileName(files.getFileName());
        file.setFileUrl(files.getFileUrl());

        filesRepository.save(file);
    }

    public Files findByFno(int i) {
        Files file = filesRepository.findByFno(i);
        return file;
    }
}

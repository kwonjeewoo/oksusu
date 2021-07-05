package com.yonamz.oksusu.repository;

import com.yonamz.oksusu.domain.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<Files, Integer> {
    Files findByFno(int fno);
    /*Files findByItemNo(Long item_no);*/
}

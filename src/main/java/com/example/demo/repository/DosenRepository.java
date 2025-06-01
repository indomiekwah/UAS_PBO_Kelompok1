// File: src/main/java/com/usu/repository/DosenRepository.java
package com.example.demo.repository;

import com.example.demo.model.Dosen;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DosenRepository extends JpaRepository<Dosen, Long> {
    Optional<Dosen> findByKodeDosen(String kodeDosen);
    boolean existsByKodeDosen(String kodeDosen);
}
// File: src/main/java/com/usu/repository/MahasiswaRepository.java
package com.example.demo.repository;

import com.example.demo.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {
    Optional<Mahasiswa> findByNim(String nim);
    boolean existsByNim(String nim);
}
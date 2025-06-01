// File: src/main/java/com/usu/repository/MataKuliahRepository.java
package com.example.demo.repository;

import com.example.demo.model.MataKuliah;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MataKuliahRepository extends JpaRepository<MataKuliah, Long> {
    Optional<MataKuliah> findByKodeMatkul(String kodeMatkul);
    boolean existsByKodeMatkul(String kodeMatkul);
}
// File: src/main/java/com/usu/repository/KelasRepository.java
package com.example.demo.repository;

import com.example.demo.model.Dosen;
import com.example.demo.model.Kelas;
import com.example.demo.model.MataKuliah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface KelasRepository extends JpaRepository<Kelas, Long> {
    Optional<Kelas> findByKodeKelas(String kodeKelas);
    boolean existsByKodeKelas(String kodeKelas);

    // Cari kelas berdasarkan mata kuliah
    List<Kelas> findByMataKuliah(MataKuliah mataKuliah);

    // Cari kelas yang diajar oleh dosen tertentu
    List<Kelas> findByDosen(Dosen dosen);

    // Cari kelas yang belum memiliki dosen
    List<Kelas> findByDosenIsNull();

    // Cek apakah dosen sudah mengajar di kelas tertentu
    @Query("SELECT CASE WHEN COUNT(k) > 0 THEN true ELSE false END " +
            "FROM Kelas k WHERE k.dosen = :dosen")
    boolean existsByDosen(@Param("dosen") Dosen dosen);

    // Cari kelas yang diikuti oleh mahasiswa tertentu
    @Query("SELECT k FROM Kelas k JOIN k.mahasiswaList m WHERE m.id = :mahasiswaId")
    List<Kelas> findByMahasiswaId(@Param("mahasiswaId") Long mahasiswaId);
}
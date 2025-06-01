// File: src/main/java/com/usu/model/Kelas.java
package com.example.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "kelas")
public class Kelas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String kodeKelas;

    @ManyToOne
    @JoinColumn(name = "dosen_id")
    private Dosen dosen;

    @ManyToOne
    @JoinColumn(name = "matakuliah_id", nullable = false)
    private MataKuliah mataKuliah;

    @ManyToMany
    @JoinTable(
            name = "kelas_mahasiswa",
            joinColumns = @JoinColumn(name = "kelas_id"),
            inverseJoinColumns = @JoinColumn(name = "mahasiswa_id")
    )
    private Set<Mahasiswa> mahasiswaList = new HashSet<>();

    // Constructors
    public Kelas() {}

    public Kelas(String kodeKelas, MataKuliah mataKuliah) {
        this.kodeKelas = kodeKelas;
        this.mataKuliah = mataKuliah;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getKodeKelas() { return kodeKelas; }
    public void setKodeKelas(String kodeKelas) { this.kodeKelas = kodeKelas; }
    public Dosen getDosen() { return dosen; }
    public void setDosen(Dosen dosen) { this.dosen = dosen; }
    public MataKuliah getMataKuliah() { return mataKuliah; }
    public void setMataKuliah(MataKuliah mataKuliah) { this.mataKuliah = mataKuliah; }
    public Set<Mahasiswa> getMahasiswaList() { return mahasiswaList; }
    public void setMahasiswaList(Set<Mahasiswa> mahasiswaList) { this.mahasiswaList = mahasiswaList; }

    // Helper method untuk menambahkan mahasiswa
    public void tambahMahasiswa(Mahasiswa mahasiswa) {
        mahasiswaList.add(mahasiswa);
        mahasiswa.getKelasList().add(this);
    }
}
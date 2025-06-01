// File: src/main/java/com/usu/model/MataKuliah.java
package com.example.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "mata_kuliah")
public class MataKuliah {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String kodeMatkul;

    @Column(nullable = false)
    private String namaMatkul;

    private int sks;

    @OneToMany(mappedBy = "mataKuliah")
    private Set<Kelas> kelasList = new HashSet<>();

    // Constructors
    public MataKuliah() {}

    public MataKuliah(String kodeMatkul, String namaMatkul, int sks) {
        this.kodeMatkul = kodeMatkul;
        this.namaMatkul = namaMatkul;
        this.sks = sks;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getKodeMatkul() { return kodeMatkul; }
    public void setKodeMatkul(String kodeMatkul) { this.kodeMatkul = kodeMatkul; }
    public String getNamaMatkul() { return namaMatkul; }
    public void setNamaMatkul(String namaMatkul) { this.namaMatkul = namaMatkul; }
    public int getSks() { return sks; }
    public void setSks(int sks) { this.sks = sks; }
    public Set<Kelas> getKelasList() { return kelasList; }
    public void setKelasList(Set<Kelas> kelasList) { this.kelasList = kelasList; }
}
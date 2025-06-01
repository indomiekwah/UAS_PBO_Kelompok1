// File: src/main/java/com/usu/model/Mahasiswa.java
package com.example.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "mahasiswa")
@PrimaryKeyJoinColumn(name = "user_id")
public class Mahasiswa extends User {
    private String nama;
    private String nim;

    @ManyToMany(mappedBy = "mahasiswaList")
    private Set<Kelas> kelasList = new HashSet<>();

    // Constructors
    public Mahasiswa() {}

    public Mahasiswa(String username, String password, String nama, String nim) {
        super(username, password, "MAHASISWA");
        this.nama = nama;
        this.nim = nim;
    }

    // Getters and Setters
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }
    public Set<Kelas> getKelasList() { return kelasList; }
    public void setKelasList(Set<Kelas> kelasList) { this.kelasList = kelasList; }
}
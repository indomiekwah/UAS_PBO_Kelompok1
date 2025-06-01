// File: src/main/java/com/usu/model/Dosen.java
package com.example.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dosen")
@PrimaryKeyJoinColumn(name = "user_id")
public class Dosen extends User {
    private String nama;
    private String kodeDosen;

    @OneToMany(mappedBy = "dosen")
    private Set<Kelas> kelasList = new HashSet<>();

    // Constructors
    public Dosen() {}

    public Dosen(String username, String password, String nama, String kodeDosen) {
        super(username, password, "DOSEN");
        this.nama = nama;
        this.kodeDosen = kodeDosen;
    }

    // Getters and Setters
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getKodeDosen() { return kodeDosen; }
    public void setKodeDosen(String kodeDosen) { this.kodeDosen = kodeDosen; }
    public Set<Kelas> getKelasList() { return kelasList; }
    public void setKelasList(Set<Kelas> kelasList) { this.kelasList = kelasList; }
}
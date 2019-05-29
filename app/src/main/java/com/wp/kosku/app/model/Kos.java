package com.wp.kosku.app.model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class Kos implements Serializable{

    private String nama;
    private String alamat;
    private String no_hp;
    private String lama_sewa;

    private String key;

    public Kos(){

    }

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return no_hp;
    }
    public void setNoHp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getLamaSewa() {
        return lama_sewa;
    }
    public void setLamaSewa(String lama_sewa) {
        this.lama_sewa = lama_sewa;
    }

    @Override
    public String toString() {
        return " "+nama+"\n" +
                " "+alamat +"\n" +
                " "+no_hp +"\n" +
                " "+lama_sewa;
    }

    public Kos(String nm, String almt, String no, String lmsw){
        nama = nm;
        alamat = almt;
        no_hp = no;
        lama_sewa = lmsw;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataType;

import java.util.Date;

/**
 *
 * @author timothy.pratama
 */
public class Post {
    private String author, judul, konten, status;
    private Date tanggal;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKonten() {
        return konten;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Post(String author, String judul, String konten, String status, Date tanggal) {
        this.author = author;
        this.judul = judul;
        this.konten = konten;
        this.status = status;
        this.tanggal = tanggal;
    }
    
    
}

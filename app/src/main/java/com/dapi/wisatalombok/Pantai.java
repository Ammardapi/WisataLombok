package com.dapi.wisatalombok;

public class Pantai {
    private String nama;
    private String logo;
    private String maps;
    private String detail;

    public Pantai() {
    }

    public Pantai(String nama, String logo, String maps, String detail) {
        this.nama = nama;
        this.logo = logo;
        this.maps = maps;
        this.detail = detail;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getMaps() {
        return maps;
    }

    public void setMaps(String maps) {
        this.maps = maps;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}

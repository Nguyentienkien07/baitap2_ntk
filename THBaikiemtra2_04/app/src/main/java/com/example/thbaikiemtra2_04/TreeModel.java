package com.example.thbaikiemtra2_04;

public class TreeModel {
    String image,name,name2,dactinh,maula;

    TreeModel(){

    }

    public TreeModel(String image, String name, String name2, String dactinh, String maula) {
        this.image = image;
        this.name = name;
        this.name2 = name2;
        this.dactinh = dactinh;
        this.maula = maula;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getDactinh() {
        return dactinh;
    }

    public void setDactinh(String dactinh) {
        this.dactinh = dactinh;
    }

    public String getMaula() {
        return maula;
    }

    public void setMaula(String maula) {
        this.maula = maula;
    }
}

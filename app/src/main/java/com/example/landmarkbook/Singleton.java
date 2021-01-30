package com.example.landmarkbook;

import android.graphics.Bitmap;

public class Singleton {
   private Bitmap chosenImage; //bu image'a sadece burada ulaşabileym
    private static Singleton singleton; //ve singleton objem oluşsun.Bunu böyle oluşturduktan sonra heryerden ulasabilirm.

    private Singleton(){

    }

    public Bitmap getChosenImage() {
        return chosenImage;  //secilen image'ı bana veriyor.
    }

    public void setChosenImage(Bitmap chosenImage) {
        this.chosenImage = chosenImage;  //birtane görsel istiyor ve seçilen görseli eşitliyor.
    }

    public static  Singleton getInstance(){
        //bura artık bana singleton objesi veya instance döndürecek.
        if(singleton==null){

            singleton= new Singleton(); //yeni singleton instance'ne eşit olsun.
        }

            return singleton; //halihazırda bana oluşturulmuş singleton'ı dön diyorm.
    }
}

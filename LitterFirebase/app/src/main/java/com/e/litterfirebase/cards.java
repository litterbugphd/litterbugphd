package com.e.litterfirebase;

public class cards {
    private String userId;
    private String name;
    private int image;
    public cards (String userId, String name, int image){
        this.userId = userId;
        this.name = name;
        this.image  = image;
    }

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public int getImage(){
        return image;
    }

    public void setImage(int image){
        this.image = image;
    }

}

package com.example.myapplication.ui.home;

public class ExampleItem {
    private String mImageResource;
    private String mText1;
    private String mText2;
    private String id;
    String [] ingredients;


    public String[] getIngredients() {
        return ingredients;
    }


    public ExampleItem(String imageResource, String text1, String text2, String id, String[] ingredients) {
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
        this.id = id;

        this.ingredients = ingredients;
    }

    public String getImageResource() {
        return mImageResource;
    }

    public String getText1() {
        return mText1;
    }

    public String getText2() {
        return mText2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ExampleItem{" +
                "mImageResource='" + mImageResource + '\'' +
                ", mText1='" + mText1 + '\'' +
                ", mText2='" + mText2 + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
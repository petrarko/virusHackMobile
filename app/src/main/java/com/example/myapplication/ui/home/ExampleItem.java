package com.example.myapplication.ui.home;

public class ExampleItem {
    private String mImageResource;
    private String mText1;
    private String mText2;
    private String id;
    private String[] ingredients;
    private Step[] descriptionSteps;

    public static class Step {
        String description;
        String imageRef;

        public Step(String description, String imageRef) {
            this.description = description;
            this.imageRef = imageRef;
        }

        public String getDescription() {

            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImageRef() {
            return imageRef;
        }

        public void setImageRef(String imageRef) {
            this.imageRef = imageRef;
        }
    }


    public String[] getIngredients() {
        return ingredients;
    }


    public ExampleItem(String imageResource, String text1, String text2, String id, String[] ingredients, Step[] description) {
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
        this.id = id;
        this.descriptionSteps = description;
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

    public Step[] getDescription() {
        return descriptionSteps;
    }

    public void setDescription(Step[] description) {
        this.descriptionSteps = description;
    }
}
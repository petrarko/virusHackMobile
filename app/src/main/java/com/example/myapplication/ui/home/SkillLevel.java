package com.example.myapplication.ui.home;

enum SkillLevel {
    EXTRA_NEWBIE("Саиый новичок"),
    NEWBIE("Новичок"),
    CAN_COOK_FRIED_EGG("Может сделать яичницу"),
    CAN_COOK_SOUP("Может приготовить суп"),
    CAN_COOK_PIE("Может приготовить пирог"),
    PROFI("Профи"),
    EXTRA_PROFI("Экстра Профи");

    String name;

    SkillLevel(String s) {
        this.name = s;
    }

    public static SkillLevel getLevel(float n) {
        return SkillLevel.values()[(int) n];
    }

    @Override
    public String toString() {
        switch (this) {
            case EXTRA_NEWBIE:
                return "EXTRA_NEWBIE";
            case NEWBIE:
                return "NEWBIE";
            case CAN_COOK_FRIED_EGG:
                return "CAN_COOK_FRIED_EGG";
            case CAN_COOK_SOUP:
                return "CAN_COOK_SOUP";
            case CAN_COOK_PIE:
                return "CAN_COOK_PIE";
            case PROFI:
                return "PROFI";
            case EXTRA_PROFI:
                return "EXTRA_PROFI";
        }
        throw new RuntimeException();
    }
}

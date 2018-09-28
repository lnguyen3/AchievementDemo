package com.example.android.acheivementdemo;

public class Family {
    String familyName;
    int numMembers;
    String stoplightColor;
    boolean hasAchievement;

    public Family() {
        this.familyName = "undefined";
        this.numMembers = 0;
        this.stoplightColor = "undefined";
        this.hasAchievement = false;
    }

    public Family(String familyName, int numMembers, String stoplightColor, boolean hasAchievement) {
        this.familyName = familyName;
        this.numMembers = numMembers;
        this.stoplightColor = stoplightColor;
        this.hasAchievement = hasAchievement;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getNumMembers() {
        return numMembers;
    }

    public String getStoplightColor() {
        return stoplightColor;
    }

    public boolean getHasAchievement() {
        return hasAchievement;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setNumMembers(int numMembers) {
        this.numMembers = numMembers;
    }

    public void setStoplightColor(String stoplightColor) {
        this.stoplightColor = stoplightColor;
    }

    public void setHasAchievement(boolean hasAchievement) {
        this.hasAchievement = hasAchievement;
    }

}

package com.zigzag_hwang.user.zigzag_project.Class;

import android.graphics.Bitmap;

public class ShopData {
    private int shopRank;
    private int shopScore;
    private String shopName;
    private String shopStyle[];
    private String shopAge[];
    private String shopImageAddress;

    private int shopStyle_MatchCount;

    public ShopData(int shopScore, String shopName, String[] shopStyle, String[] shopAge, String shopImageAddress ) {
        this.shopScore = shopScore;
        this.shopName = shopName;
        this.shopStyle = shopStyle;
        this.shopAge = shopAge;
        this.shopImageAddress = shopImageAddress;
        shopStyle_MatchCount = 0;
    }

    public int getShopRank() {
        return shopRank;
    }

    public void setShopRank(int shopRank) {
        this.shopRank = shopRank;
    }

    public int getShopScore() {
        return shopScore;
    }

    public void setShopScore(int shopScore) {
        this.shopScore = shopScore;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopStyle() {
        String style = "";
        for(String data : shopStyle){
            style += data+" ";
        }
        return style;
    }

    public void setShopStyle(String shopStyle[]) {
        this.shopStyle = shopStyle;
    }

    public String getShopAge() {
        String age = "";
        if(shopAge[0].equals("1"))
            age = "10대";

        if(shopAge[1].equals("1") || shopAge[2].equals("1") || shopAge[3].equals("1"))
            age += " 20대";

        if(shopAge[4].equals("1") || shopAge[5].equals("1") ||shopAge[6].equals("1") )
            age += " 30대";

        return age;
    }

    public void setShopAge(String shopAge[]) {
        this.shopAge = shopAge;
    }

    public String getShsopImageAddress() {
        return shopImageAddress;
    }

    public int getShopStyle_MatchCount() {
        return shopStyle_MatchCount;
    }

    public void setShopStyle_MatchCount(int shopStyle_MatchCount) {
        this.shopStyle_MatchCount = shopStyle_MatchCount;
    }
}

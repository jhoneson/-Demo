package helper;

/**
 * Created by scxh on 2016/7/25.
 */
public class store {
    int merchantID;
    String name;

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    String coupon;
    String location;
    String distance;
    String picUrl;
    String couponType;
    String cardType;
    String groupType;

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    double gpsX;
    double gpsY;
    int goodSayNum;
    int midSayNum;
    int badSayNum;

    public int getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(int merchantID) {
        this.merchantID = merchantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public double getGpsX() {
        return gpsX;
    }

    public void setGpsX(double gpsX) {
        this.gpsX = gpsX;
    }

    public double getGpsY() {
        return gpsY;
    }

    public void setGpsY(double gpsY) {
        this.gpsY = gpsY;
    }

    public int getGoodSayNum() {
        return goodSayNum;
    }

    public void setGoodSayNum(int goodSayNum) {
        this.goodSayNum = goodSayNum;
    }

    public int getMidSayNum() {
        return midSayNum;
    }

    public void setMidSayNum(int midSayNum) {
        this.midSayNum = midSayNum;
    }

    public int getBadSayNum() {
        return badSayNum;
    }

    public void setBadSayNum(int badSayNum) {
        this.badSayNum = badSayNum;
    }
}

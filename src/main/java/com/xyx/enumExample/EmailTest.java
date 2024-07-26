package com.xyx.enumExample;

// EmailTestEnum.java
public enum EmailTest{
    YSH("5555555@163.com", 1, "A市", "9527"),
    YSH2("77777777@163.com", 1, "B市", "9527");

    private String emailCode;
    private int index;
    private String area;
    private String areaCode;
    // 构造方法
    private EmailTest(String emailCode, int index,String area,String areaCode) {
        this.emailCode = emailCode;
        this.index = index;
        this.area = area;
        this.areaCode = areaCode;
    }

    // get set 方法
    public String getEmailCode() {
        return emailCode;
    }
    public String getAreaCode() {
        return areaCode;
    }
    public String getArea() {
        return area;
    }
    public int getIndex() {
        return index;
    }
}


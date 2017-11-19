package ru.tinkoff.data;

public enum Region {

    Moscow("Москва","Москве");

    private String regionName;
    private String declensionName;

    Region(String regionName, String declensionName) {
        this.regionName = regionName;
        this.declensionName = declensionName;
    }

    public String getDeclensionName() {
        return declensionName;
    }

    public String getRegionName() {
        return regionName;
    }
}

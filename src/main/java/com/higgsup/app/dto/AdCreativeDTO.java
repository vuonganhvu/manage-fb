package com.higgsup.app.dto;

/**
 * Created on 14-Sep-17.
 * OwnerBy anhvu
 */
public class AdCreativeDTO {

    private String adCreativeId;
    private String adCreativeName;
    private String objectStoryId;

    public AdCreativeDTO() {
    }

    public String getAdCreativeId() {
        return adCreativeId;
    }

    public void setAdCreativeId(String adCreativeId) {
        this.adCreativeId = adCreativeId;
    }

    public String getAdCreativeName() {
        return adCreativeName;
    }

    public void setAdCreativeName(String adCreativeName) {
        this.adCreativeName = adCreativeName;
    }

    public String getObjectStoryId() {
        return objectStoryId;
    }

    public void setObjectStoryId(String objectStoryId) {
        this.objectStoryId = objectStoryId;
    }
}

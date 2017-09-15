package com.higgsup.app.dto;

import com.higgsup.common.CommonDTO;

/**
 * Created on 15-Sep-17.
 * OwnerBy anhvu
 */
public class AdDTO extends CommonDTO {
    private String adId;
    private String adName;
    private String adsetId;
    private String adCreativeId;

    public AdDTO() {
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdsetId() {
        return adsetId;
    }

    public void setAdsetId(String adsetId) {
        this.adsetId = adsetId;
    }

    public String getAdCreativeId() {
        return adCreativeId;
    }

    public void setAdCreativeId(String adCreativeId) {
        this.adCreativeId = adCreativeId;
    }
}

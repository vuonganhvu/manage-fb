package com.higgsup.app.dto;

import com.higgsup.common.CommonDTO;

import java.util.List;

/**
 * Created on 14-Sep-17.
 * OwnerBy anhvu
 */
public class CampaignDTO extends CommonDTO {

    private String campaignId ;
    private String campaignName;

    private List<AdSetDTO> adSetDTOList;

    public CampaignDTO() {
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public List<AdSetDTO> getAdSetDTOList() {
        return adSetDTOList;
    }

    public void setAdSetDTOList(List<AdSetDTO> adSetDTOList) {
        this.adSetDTOList = adSetDTOList;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }
}

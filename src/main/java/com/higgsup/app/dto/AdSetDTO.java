package com.higgsup.app.dto;

import com.higgsup.common.CommonDTO;
import com.higgsup.common.utils.DataUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 14-Sep-17.
 * OwnerBy anhvu
 */
public class AdSetDTO extends CommonDTO {

    private String adSetId;
    private String adSetName;
    private Long dailyBudget;
    private String campaignId;
    private List<AdCreativeDTO> adCreativeDTOList;
    private List<AdDTO> adDTOList;

    public AdSetDTO() {
    }

    public String getAdSetId() {
        return adSetId;
    }

    public void setAdSetId(String adSetId) {
        this.adSetId = adSetId;
    }

    public String getAdSetName() {
        return adSetName;
    }

    public void setAdSetName(String adSetName) {
        this.adSetName = adSetName;
    }

    public Long getDailyBudget() {
        return dailyBudget;
    }

    public void setDailyBudget(Long dailyBudget) {
        this.dailyBudget = dailyBudget;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public List<AdCreativeDTO> getAdCreativeDTOList() {
        return adCreativeDTOList;
    }

    public void setAdCreativeDTOList(List<AdCreativeDTO> adCreativeDTOList) {
        this.adCreativeDTOList = adCreativeDTOList;
    }

    public List<AdDTO> getAdDTOList() {
        return adDTOList;
    }

    public void setAdDTOList(List<AdDTO> adDTOList) {
        this.adDTOList = adDTOList;
    }

    public void addAdDTO(AdDTO adDTO) {
        if(DataUtils.isNull(this.adDTOList)){
            this.adDTOList = new ArrayList<AdDTO>();
        }
        this.adDTOList.add(adDTO);
    }
}

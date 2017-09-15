package com.higgsup.app.service;

import com.higgsup.app.dto.CampaignDTO;

/**
 * Created on 14-Sep-17.
 * OwnerBy anhvu
 */
public interface CampaignService {

    CampaignDTO createCampaign (CampaignDTO campaignDTO) throws Exception;

    CampaignDTO createQuickCampaign(CampaignDTO campaignDTO) throws Exception;
}

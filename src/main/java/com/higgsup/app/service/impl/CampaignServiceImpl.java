package com.higgsup.app.service.impl;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.Campaign;
import com.higgsup.app.dto.AdCreativeDTO;
import com.higgsup.app.dto.AdSetDTO;
import com.higgsup.app.dto.CampaignDTO;
import com.higgsup.app.service.AdCreativeService;
import com.higgsup.app.service.AdService;
import com.higgsup.app.service.AdsetService;
import com.higgsup.app.service.CampaignService;
import com.higgsup.common.CommonService;
import com.higgsup.common.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 14-Sep-17.
 * OwnerBy anhvu
 */
@Service
public class CampaignServiceImpl extends CommonService implements CampaignService {

    @Autowired
    AdsetService adsetService;

    @Override
    public CampaignDTO createCampaign (CampaignDTO campaignDTO) throws Exception{
        try {
            validateCreateCampaign(campaignDTO);
            APIContext context = getContext();
            Campaign campaign = new AdAccount(accountId, context).createCampaign()
                    .setName(campaignDTO.getCampaignName())
                    .setObjective(Campaign.EnumObjective.VALUE_POST_ENGAGEMENT)
                    .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
                    .execute();
            String campaign_id = campaign.getId(); //23842648730950374
            campaignDTO.setCampaignId(campaign_id);
            System.out.println("id Campaign = " + campaign_id);
            return campaignDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Có lỗi xảy ra khi tạo chiến dịch");
        }
    }

    @Override
    public CampaignDTO createQuickCampaign(CampaignDTO campaignDTO) throws Exception {
        try {
            campaignDTO = createCampaign(campaignDTO);
            validateCreateQuickCampaign(campaignDTO);
            for(AdSetDTO adSetDTO : campaignDTO.getAdSetDTOList()) {
                adSetDTO.setCampaignId(campaignDTO.getCampaignId());
               AdSetDTO adSetNew = adsetService.createAdSetQuick(adSetDTO);
               adSetDTO.setAdSetId(adSetNew.getAdSetId());
            }
            return campaignDTO;
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }

    }

    private void validateCreateCampaign(CampaignDTO campaignDTO) throws Exception {
        if (DataUtils.isNull(campaignDTO) || DataUtils.isNullOrEmpty(campaignDTO.getCampaignName())) {
            throw new Exception("Dữ liệu đầu vào không chuẩn");
        }
    }

    private void validateCreateQuickCampaign(CampaignDTO campaignDTO) throws Exception {
        if (DataUtils.isNullOrEmpty(campaignDTO.getAdSetDTOList())) {
            throw new Exception("Danh sách Adset không được để trống");
        }
    }
}

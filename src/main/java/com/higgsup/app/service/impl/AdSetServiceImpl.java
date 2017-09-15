package com.higgsup.app.service.impl;

import com.facebook.ads.sdk.*;
import com.higgsup.app.dto.AdCreativeDTO;
import com.higgsup.app.dto.AdDTO;
import com.higgsup.app.dto.AdSetDTO;
import com.higgsup.app.service.AdCreativeService;
import com.higgsup.app.service.AdService;
import com.higgsup.app.service.AdsetService;
import com.higgsup.common.CommonService;
import com.higgsup.common.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created on 14-Sep-17.
 * OwnerBy anhvu
 */

@Service
public class AdSetServiceImpl extends CommonService implements AdsetService {

    @Autowired
    AdCreativeService adCreativeService;
    @Autowired
    AdService adService;

    @Override
    public AdSetDTO createAdSet (AdSetDTO adSetDTO) throws Exception {
        validateCreateAdset(adSetDTO);
        try {
            APIContext context = getContext();
            AdSet adSet = new AdAccount(accountId, context).createAdSet()
                    .setName(adSetDTO.getAdSetName())
                    .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_REACH)
                    .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
                    .setIsAutobid(true)
                    .setDailyBudget(adSetDTO.getDailyBudget())
                    .setCampaignId(adSetDTO.getCampaignId())
                    .setTargeting(
                            new Targeting()
                                    .setFieldGeoLocations(
                                            new TargetingGeoLocation()
                                                    .setFieldCountries(Arrays.asList("US"))
                                    )
                    )
                    .setStatus(AdSet.EnumStatus.VALUE_ACTIVE)
                    .execute();
            String ad_set_id = adSet.getId(); //23842648744970374
            System.out.println("ad_set_id = " + ad_set_id);
            adSetDTO.setAdSetId(ad_set_id);
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception("Có lỗi xảy ra khi gọi api facebook");
        }
        return adSetDTO;
    }

    @Override
    public AdSetDTO createAdSetQuick (AdSetDTO adSetDTO)  throws Exception{
        adSetDTO = createAdSet(adSetDTO);

        validateCreateQuickAdset(adSetDTO);
        int i = 0;
        for (AdCreativeDTO adCreativeDTO : adSetDTO.getAdCreativeDTOList()) {
            AdCreativeDTO adCreativeNew = adCreativeService.createAdCreative(adCreativeDTO);
            adCreativeDTO.setAdCreativeId(adCreativeNew.getAdCreativeId());
            AdDTO adDTO = new AdDTO();
            adDTO.setAdName(adCreativeDTO.getAdCreativeName());
            adDTO.setAdCreativeId(adCreativeNew.getAdCreativeId());
            adDTO.setAdsetId(adSetDTO.getAdSetId());
            adDTO = adService.createAd(adDTO);
            adSetDTO.addAdDTO(adDTO);
        }
        return adSetDTO;
    }

    private void validateCreateAdset(AdSetDTO adSetDTO) throws Exception{
        if(DataUtils.isNull(adSetDTO)){
            throw new Exception("AdsetDTO không được để trống");
        }
        if(DataUtils.isNullOrEmpty(adSetDTO.getCampaignId())){
            throw new Exception("Campaign không được để trống");
        }
        if(DataUtils.isNullOrEmpty(adSetDTO.getAdSetName())){
            throw new Exception("Tên adset không được để trống");
        }
        if(DataUtils.isNullOrZezo(adSetDTO.getDailyBudget())){
            throw new Exception("dailyBuget không được để trống");
        }
        if(adSetDTO.getDailyBudget() < 50000){
            throw new Exception("dailyBuget tối thiểu là 50000");
        }
    }

    private void validateCreateQuickAdset(AdSetDTO adSetDTO) throws Exception{
        if(DataUtils.isNullOrEmpty(adSetDTO.getAdCreativeDTOList())){
            throw new Exception("Danh sách adCreativeDTO không được để trống");
        }

    }
}

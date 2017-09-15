package com.higgsup.app.service.impl;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdCreative;
import com.higgsup.app.dto.AdCreativeDTO;
import com.higgsup.app.service.AdCreativeService;
import com.higgsup.common.CommonService;
import com.higgsup.common.utils.DataUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created on 14-Sep-17.
 * OwnerBy anhvu
 */

@Service
public class AdCreativeServiceImpl extends CommonService implements AdCreativeService {

    @Value("${object.story.id}")
    protected String objectStoryIdConfig;

    @Override
    public AdCreativeDTO createAdCreative(AdCreativeDTO adCreativeDTO) throws Exception {
        validateCreate(adCreativeDTO);
        try {
            APIContext context = getContext();
            AdCreative adCreative = new AdAccount(accountId, context).createAdCreative()
                    .setName(adCreativeDTO.getAdCreativeName())
                    .setObjectStoryId(adCreativeDTO.getObjectStoryId())
                    .execute();
            String ad_creative_id = adCreative.getId();
            System.out.println("ad_creative_id = " + ad_creative_id);
            adCreativeDTO.setAdCreativeId(ad_creative_id);
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception("Có lỗi xảy ra khi gọi api facebook");
        }
        return adCreativeDTO;
    }

    private void validateCreate(AdCreativeDTO adCreativeDTO) throws Exception {
        if(DataUtils.isNull(adCreativeDTO)) {
            throw new Exception("adCreative không được để trống");
        }
        if(DataUtils.isNullOrEmpty(adCreativeDTO.getAdCreativeName())){
            throw new Exception("Tên adCreative không được để trống");
        }
        if(DataUtils.isNullOrEmpty(adCreativeDTO.getObjectStoryId())){
            adCreativeDTO.setObjectStoryId(objectStoryIdConfig);
        }
    }

}

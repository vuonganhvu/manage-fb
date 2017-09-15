package com.higgsup.app.service.impl;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.Ad;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdCreative;
import com.higgsup.app.dto.AdDTO;
import com.higgsup.app.service.AdService;
import com.higgsup.common.CommonService;
import com.higgsup.common.utils.DataUtils;
import org.springframework.stereotype.Service;

/**
 * Created on 15-Sep-17.
 * OwnerBy anhvu
 */
@Service
public class AdServiceImpl extends CommonService implements AdService {

    public AdDTO createAd (AdDTO adDTO) throws Exception {
        validateCreate(adDTO);
        try {
            APIContext context = getContext();
            Ad ad = new AdAccount(accountId, context).createAd()
                    .setStatus(Ad.EnumStatus.VALUE_PAUSED)
                    .setAdsetId(adDTO.getAdsetId())
                    .setName(adDTO.getAdName())
                    .setCreative(
                            new AdCreative()
                                    .setFieldId(adDTO.getAdCreativeId())
                    )
                    .execute();
            String ad_id = ad.getId();
            System.out.println("ad_id " + ad_id);
            adDTO.setAdId(ad_id);
            return adDTO;
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception("Có lỗi xảy ra khi gọi api facebook");
        }
    }

    private void validateCreate(AdDTO adDTO ) throws Exception {
        if (DataUtils.isNull(adDTO)) {
            throw new Exception("adDTO không được để trống");
        }
        if(DataUtils.isNullOrEmpty(adDTO.getAdName())){
            throw new Exception("Tên ad không được để trống");
        }
        if(DataUtils.isNullOrEmpty(adDTO.getAdsetId())){
            throw new Exception("adSetId không được để trống");
        }
        if(DataUtils.isNullOrEmpty(adDTO.getAdCreativeId())){
            throw new Exception("adCreativeId không được để trống");
        }
    }
}

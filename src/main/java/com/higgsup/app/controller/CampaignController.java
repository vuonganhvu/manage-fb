package com.higgsup.app.controller;


import com.higgsup.app.dto.CampaignDTO;
import com.higgsup.app.service.CampaignService;
import com.higgsup.common.CommonController;
import com.higgsup.common.utils.ResponeComon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created on 14-Sep-17.
 * OwnerBy anhvu
 */

@RestController
@RequestMapping("/campaign")
public class CampaignController  extends CommonController {

    @Autowired
    CampaignService campaignService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    public ResponeComon<CampaignDTO> createCampaign (@RequestBody @Valid final CampaignDTO campaignDTO){
        ResponeComon<CampaignDTO> responeComon = new ResponeComon<CampaignDTO>();
        try {
            CampaignDTO ret = campaignService.createCampaign(campaignDTO);
            responeComon.successfulRespone(ret);
        } catch (Exception e){
            responeComon.failedRespone(e.getMessage());
        }
        return responeComon;
    }

    @RequestMapping(value = "/quickCreate", method = RequestMethod.POST, produces = "application/json")
    public ResponeComon<CampaignDTO> quickCreateCampaign (@RequestBody @Valid final CampaignDTO campaignDTO){
        ResponeComon<CampaignDTO> responeComon = new ResponeComon<CampaignDTO>();
        try {
            CampaignDTO ret = campaignService.createQuickCampaign(campaignDTO);
            responeComon.successfulRespone(ret);
        } catch (Exception e){
            responeComon.failedRespone(e.getMessage());
        }
        return responeComon;
    }

}

package com.higgsup.app.controller;

import com.higgsup.app.dto.AdSetDTO;
import com.higgsup.app.dto.CampaignDTO;
import com.higgsup.app.service.AdsetService;
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
@RequestMapping("/adset")
public class AdSetController extends CommonController {

    @Autowired
    AdsetService adsetService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    public ResponeComon<AdSetDTO> createAdSet (@RequestBody @Valid final AdSetDTO adSetDTO){
        ResponeComon<AdSetDTO> responeComon = new ResponeComon<AdSetDTO>();
        try {
            AdSetDTO ret = adsetService.createAdSet(adSetDTO);
            responeComon.successfulRespone(ret);
        } catch (Exception e){
            responeComon.failedRespone(e.getMessage());
        }
        return responeComon;
    }
}

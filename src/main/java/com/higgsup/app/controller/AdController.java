package com.higgsup.app.controller;

import com.higgsup.app.dto.AdDTO;
import com.higgsup.app.service.AdService;
import com.higgsup.app.service.TestService;
import com.higgsup.common.CommonController;
import com.higgsup.common.utils.ResponeComon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created on 15-Sep-17.
 * OwnerBy anhvu
 */
@RestController
@RequestMapping("/ad")
public class AdController extends CommonController {

    @Autowired
    AdService adService;
    @Autowired
    TestService testService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    public ResponeComon<AdDTO> createAdCreative (@RequestBody @Valid final AdDTO adDTO) {
        ResponeComon<AdDTO> responeComon = new ResponeComon<AdDTO>();
        try {
            AdDTO ret = adService.createAd(adDTO);
            responeComon.successfulRespone(ret);
        } catch (Exception e){
            responeComon.failedRespone(e.getMessage());
        }
        return responeComon;
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST, produces = "application/json")
    public ResponeComon<String> test () {
        ResponeComon<String> responeComon = new ResponeComon<String>();
        testService.test();
        responeComon.successfulRespone("dfdsf");
        return responeComon;
    }
}

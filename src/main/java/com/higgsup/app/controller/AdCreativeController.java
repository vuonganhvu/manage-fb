package com.higgsup.app.controller;

import com.higgsup.app.dto.AdCreativeDTO;
import com.higgsup.app.service.AdCreativeService;
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
@RequestMapping("/adcreative")
public class AdCreativeController extends CommonController {

    @Autowired
    AdCreativeService adCreativeService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
    public ResponeComon<AdCreativeDTO> createAdCreative (@RequestBody @Valid final AdCreativeDTO adCreativeDTO) {
        ResponeComon<AdCreativeDTO> responeComon = new ResponeComon<AdCreativeDTO>();
        try {
            AdCreativeDTO ret = adCreativeService.createAdCreative(adCreativeDTO);
            responeComon.successfulRespone(ret);
        } catch (Exception e){
            responeComon.failedRespone(e.getMessage());
        }
        return responeComon;
    }
}

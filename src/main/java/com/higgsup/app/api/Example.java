package com.higgsup.app.api;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.Campaign;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 13-Sep-17.
 * OwnerBy anhvu
 */
@RestController
@RequestMapping(value = "example")
public class Example {

    @Value("${access.token}")
    private String accessToken;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    String test() {
        try {
            APIContext context = new APIContext(accessToken).enableDebug(true);
            Campaign campaign = new AdAccount("854835981332097", context).createCampaign()
                    .setName("My app")
                    .setObjective(Campaign.EnumObjective.VALUE_POST_ENGAGEMENT)
                    .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
                    .execute();
            String campaign_id = campaign.getId();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Hello World! " + accessToken;
    }
}

package com.higgsup.app.api;

import com.facebook.ads.sdk.*;

import java.util.Arrays;

/**
 * Created on 14-Sep-17.
 * OwnerBy anhvu
 */
public class MainTest {
    public static void main(String[] args) {
//        String accessToken = "378961742521084|CTjqDzRfMe62_Oq0OTALUiHf2Gs";
        String accessToken = "EAAFYqegL4vwBAKRpLZC3nZCnOAag8sNvMbcW12co6k8Ma9VNHc1jwujTfbVBPuj1W5krnjFKiR2JXkTZCJykSD28m5fZBRTvML8JOZBLZCsSInZBkNOazDuZCFZAo1n92qOayIIW2b5pRfBTW0noA1X6I46bxW6kgY66RxUpmc7AMUanfBLROFkEYrbfK7iSvvdpldy4ZAIe4twQZDZD";
        String accountId = "854835981332097";
        try {
            APIContext context = new APIContext(accessToken).enableDebug(true);
            Campaign campaign = new AdAccount(accountId, context).createCampaign()
                    .setName("My app 2")
                    .setObjective(Campaign.EnumObjective.VALUE_POST_ENGAGEMENT)
                    .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
                    .execute();
            String campaign_id = campaign.getId(); //23842648730950374
            System.out.println("id Campaign = " + campaign_id);

            AdSet adSet = new AdAccount(accountId, context).createAdSet()
                    .setName("My AdSet 2")
                    .setOptimizationGoal(AdSet.EnumOptimizationGoal.VALUE_REACH)
                    .setBillingEvent(AdSet.EnumBillingEvent.VALUE_IMPRESSIONS)
                    .setIsAutobid(true)
                    .setDailyBudget(50000l)
                    .setCampaignId(campaign_id)
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

            AdCreative adCreative = new AdAccount(accountId, context).createAdCreative()
                    .setName("Sample Promoted Post")
                    .setObjectStoryId("325626107612490_837241426450953")
                    .execute();
            String ad_creative_id = adCreative.getId(); // 23842632950580374

            Ad ad = new AdAccount(accountId, context).createAd()
                    .setStatus(Ad.EnumStatus.VALUE_PAUSED)
                    .setAdsetId(ad_set_id)
                    .setName("My Ad")
                    .setCreative(
                            new AdCreative()
                                    .setFieldId(ad_creative_id)
                    )
                    .execute();
            String ad_id = ad.getId();
            new Ad(ad_id, context).getPreviews()
                    .setAdFormat(AdPreview.EnumAdFormat.VALUE_DESKTOP_FEED_STANDARD)
                    .execute();
            System.out.println("ad_creative_id = " + ad_id); //23842648783040374
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
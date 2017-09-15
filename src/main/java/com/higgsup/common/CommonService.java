package com.higgsup.common;

import com.facebook.ads.sdk.APIContext;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created on 14-Sep-17.
 * OwnerBy anhvu
 */
public class CommonService {

    @Value("${access.token}")
    protected String accessToken;

    @Value("${account.id}")
    protected String accountId;

    protected APIContext getContext() {
        return new APIContext(accessToken).enableDebug(true);
    }
}

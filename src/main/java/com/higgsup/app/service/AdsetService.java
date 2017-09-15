package com.higgsup.app.service;

import com.higgsup.app.dto.AdSetDTO;

/**
 * Created on 14-Sep-17.
 * OwnerBy anhvu
 */
public interface AdsetService {

    AdSetDTO createAdSet (AdSetDTO adSetDTO)  throws Exception;

    AdSetDTO createAdSetQuick (AdSetDTO adSetDTO)  throws Exception;
}

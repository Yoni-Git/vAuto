package com.cox.vauto.service;

import com.cox.vauto.model.Dealer;
import org.springframework.stereotype.Service;

/**
 * Author, Yonatan,12-07-2018
 */

@Service
public interface DealerService {
    Dealer getDealer(int dealerId);
}

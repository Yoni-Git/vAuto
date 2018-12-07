package com.cox.vauto.dao;

import com.cox.vauto.model.Dealer;
import org.springframework.stereotype.Repository;


/**
 * Author, Yonatan,12-07-2018
 */

@Repository
public interface DealerDAO {
    Dealer getDealer(int dealerId);
}

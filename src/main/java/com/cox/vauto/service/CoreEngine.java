package com.cox.vauto.service;

import com.cox.vauto.dto.DealerDTO;
import com.cox.vauto.model.Result;
import org.springframework.stereotype.Service;
/**
 * Author, Yonatan,12-07-2018
 */


@Service
public interface CoreEngine {
    DealerDTO aggregate();
    Result submitAnswer(DealerDTO dealers);
}

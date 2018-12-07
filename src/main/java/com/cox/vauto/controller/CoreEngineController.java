package com.cox.vauto.controller;

import com.cox.vauto.dto.DealerDTO;
import com.cox.vauto.model.Result;
import com.cox.vauto.service.CoreEngine;
import com.cox.vauto.service.DataSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author, Yonatan,12-07-2018
 */
@RestController
@RequestMapping("/")
public class CoreEngineController {

    /**
     * The Core Engine is the Class that dispatches 9 threads to execute data fetch simultiounesly.
     * 9 is chosen as the data size of vehicles is usually 9.
     */
    @Autowired
    CoreEngine coreEngine;

    @Autowired
    DataSetService dataSetService;

    /**
     *
     * @return Result of the answer which essentially checks data validity and runtime
     * between dataset Id generation and answer submission
     */
    @GetMapping(value = "/submit_answer" ,  produces = "application/json")
    @ResponseBody
    public Result submitAnswer(){
        dataSetService.resetDataSetId();
        return  coreEngine.submitAnswer(coreEngine.aggregate());
    }


    /**
     * THis method is created to validate how the api call works , no need to regenerate the Dataset-Id as we dont have Timer
     * @return LIST of dealers with Vehicle information included
     */
    @GetMapping(value = "/answer" ,  produces = "application/json")
    @ResponseBody
    public DealerDTO getVehicleIds(){
        return   coreEngine.aggregate();
    }




}


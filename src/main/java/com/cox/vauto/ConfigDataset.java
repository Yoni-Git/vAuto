package com.cox.vauto;


import com.cox.vauto.model.DataSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

/**
 * Author, Yonatan,12-07-2018
 */

@Configuration
public class ConfigDataset {
    private static final Logger log = LoggerFactory.getLogger(ConfigDataset.class);

    @Value("${vAuto.base.url}")
    private String BASE_URL;

    @Value("${dataset.url}")
    private String DATASET_API;

    /**
     * Every request need to have a new Dataset
     * as the time from the api is measured for the duration between data-set generation and answer submission
     * @return
     */
    @Bean
    @Scope(scopeName= WebApplicationContext.SCOPE_APPLICATION, proxyMode= ScopedProxyMode.TARGET_CLASS)
    public DataSet getDataSet() {
        log.info("==== Managed Bean DataSet  START =======");
        RestTemplate restTemplate = new RestTemplate();
        DataSet dataset = restTemplate.getForObject( BASE_URL + DATASET_API, DataSet.class);
        log.info(dataset.toString());
        log.info("==== DataSet Set END =======");
        return dataset;
    }
}

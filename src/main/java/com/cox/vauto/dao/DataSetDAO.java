package com.cox.vauto.dao;

import com.cox.vauto.model.DataSet;
import org.springframework.stereotype.Repository;


/**
 * Author, Yonatan,12-07-2018
 */

@Repository
public interface DataSetDAO {
     DataSet getDataSet();
    }

package com.cox.vauto.dao;

import com.cox.vauto.dto.VehicleDTO;
import org.springframework.stereotype.Repository;


/**
 * Author, Yonatan,12-07-2018
 */

@Repository
public interface VehicleDAO {
   int[] getVehicleIdList();
   VehicleDTO getVehicle(int vehicleId);

}

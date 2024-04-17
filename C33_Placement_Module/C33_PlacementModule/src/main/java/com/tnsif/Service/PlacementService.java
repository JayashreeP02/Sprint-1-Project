package com.tnsif.Service;

import com.tnsif.Entity.Placement;
import com.tnsif.Repository.PlacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacementService {
    @Autowired
    PlacementRepository placementRepository;

    public Placement addPlacement(Placement placement){
        return placementRepository.save(placement);
    }

    public List<Placement> getAllPlacements(){
        return placementRepository.findAll();
    }

}

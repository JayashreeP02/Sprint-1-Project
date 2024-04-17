package com.tnsif.Controller;

import com.tnsif.Entity.Placement;
import com.tnsif.Repository.PlacementRepository;
import com.tnsif.Service.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/placement")
public class PlacementController {

    @Autowired
    PlacementService placementService;

    @PostMapping("/addPlacement")
    public ResponseEntity<Placement> addPlacement(@RequestBody Placement placement) {

        try {
            Placement response = placementService.addPlacement(placement);
            return ResponseEntity.status(HttpStatus.OK).body(placement);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

        @GetMapping("/all-placements")
        public ResponseEntity<List<Placement>> getPlacements(){
            try{
                List<Placement> response = placementService.getAllPlacements();
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }
        @Autowired
        PlacementRepository placementRepository;
    @PutMapping("/update-placement/{id}")
    public ResponseEntity<Placement> updatePlacement(@PathVariable Long id, @RequestBody Placement updatedPlacement) {
        Optional<Placement> optionalPlacement = placementRepository.findById(id);
        if (optionalPlacement.isPresent()) {
            Placement existingPlacement = optionalPlacement.get();
            existingPlacement.setCompanyName(updatedPlacement.getCompanyName());
            existingPlacement.setRole(updatedPlacement.getRole());
            existingPlacement.setPlacementDate(updatedPlacement.getPlacementDate());
            Placement savedPlacement = placementRepository.save(existingPlacement);
            return ResponseEntity.ok(savedPlacement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-placement/{id}")
    public ResponseEntity<?> deletePlacement(@PathVariable Long id) {
        Optional<Placement> optionalItem = placementRepository.findById(id);
        if (optionalItem.isPresent()) {
            placementRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

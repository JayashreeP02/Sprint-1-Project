package com.tnsif.Repository;

import com.tnsif.Entity.Placement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface PlacementRepository extends JpaRepository<Placement,Long>{

}

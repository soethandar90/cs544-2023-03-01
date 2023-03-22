package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query( value = "SELECT * FROM Location  WHERE planId = :planId",nativeQuery = true)
    List<Location> findLocationByPlan(Integer planId);


//    @Query( "SELECT l FROM Location l WHERE l.plan.planId = :planId")
//    List<Location> findLocationsOfOnePlanByPlanId(int id);



    //    @Query("select  p from Post p where p.title=:param")
    //    public List<Post> getPosts(String param);

}

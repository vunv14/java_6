package com.example.training_JAva6.Repository;

import com.example.training_JAva6.Entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status,Long> {

    @Query(
            value = """
                
                select st.id,st.status_name from status st
""",
            nativeQuery = true

    )
    List<Status> listStatus();

}
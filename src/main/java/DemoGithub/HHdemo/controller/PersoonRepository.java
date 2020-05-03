package DemoGithub.HHdemo.controller;


import org.springframework.data.jpa.repository.JpaRepository;
import DemoGithub.HHdemo.model.Persoon;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface PersoonRepository extends JpaRepository<Persoon, Long> {

}

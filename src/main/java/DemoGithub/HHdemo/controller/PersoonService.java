package DemoGithub.HHdemo.controller;

import DemoGithub.HHdemo.dto.PersoonDTO;
import DemoGithub.HHdemo.model.Persoon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional

public class PersoonService {

    @Autowired
    private PersoonRepository repository;

    public Optional<Persoon> findPersoonById(Long id) {
        Optional<Persoon> persoonOptional = repository.findById(id);
        return persoonOptional;
    }
    public Persoon postPersoon(Persoon persoon){
        return repository.save(persoon);
    }
    public void deletePersoonById(Long id) {
        repository.deleteById(id);
    }
    public void deletePersonen() {
        repository.deleteAll();
    }
    private static Map<Long, Persoon> personen;

    static {
        personen = new HashMap<Long, Persoon>() {
            {
                put(1L, new Persoon(1L, "123123", "Cor", "", "Faber", "0612345678", "", "", "", "" ));
                put(2L, new Persoon(2L, "123124", "Rutger", "", "Spaans", "0612345679", "", "", "", ""));
                put(3L, new Persoon(3L, "123125", "Martin", "", "Berends", "0612345670", "", "", "", ""));
                //put(1L, new Persoon(1L, "Henk", "", "Heusdens", "222999944", "Croeselaan", "235 bis A", "3521BP", "Utrecht", "0644995703"));
            }
        };
    }

    public Persoon findPersoonByIdIntern(Long id) {
        return personen.get(id);
    }

    public List<Persoon> getAllePersonen(){
//        return new ArrayList<Persoon>(personen.values());
        return repository.findAll();
    }

    public Persoon deletePersoonByIdIntern(Long id) {
        return personen.remove(id);
    }

}


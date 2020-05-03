package DemoGithub.HHdemo.rest;

import DemoGithub.HHdemo.dto.PersoonDTO;
import DemoGithub.HHdemo.exceptions.ResourceNotFoundException;
import DemoGithub.HHdemo.model.Persoon;
import DemoGithub.HHdemo.controller.PersoonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personen")
public class PersoonEndpoint {
    @Autowired
    PersoonService service; //= new PersoonService();

    @GetMapping("/{id}")  // org.springframework
    public @ResponseBody
            PersoonDTO findPersoonById(@PathVariable Long id) {
        System.out.println("LOG- REST: getPersoonById/" + id + " - Aanroep van onze restserivce voor het opvragen van één persoon.");
        Optional<Persoon> persoonOptional = service.findPersoonById(id);

        if (!persoonOptional.isPresent()) {
            throw new ResourceNotFoundException("Id not found ID: " + id);
        }
        Persoon persoon = persoonOptional.get();
        return new PersoonDTO(persoon);
    }

    @GetMapping("")
    public List<PersoonDTO> getAllePersonen() {
        System.out.println("LOG- REST: personen - Aanroep van onze restserivce voor het opvragen van alle personen.");
        List<Persoon> personen = service.getAllePersonen();
        List<PersoonDTO> dtoLijst1 = new ArrayList<>();
        for (Persoon persoon1 : personen) {
            dtoLijst1.add(new PersoonDTO(persoon1));
        }
        return dtoLijst1;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Persoon postPersoon (@RequestBody Persoon persoon){
        System.out.println(" ");
        return service.postPersoon(persoon);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<PersoonDTO> deletePersoonById(@PathVariable Long id) {
        System.out.println("LOG- REST: deletePersoonById/" + id + " - Aanroep van onze restserivce voor het deleten van één persoon.");
        Optional<Persoon> persoonOptional = service.findPersoonById(id);
        if (persoonOptional.isPresent()) {
            service.deletePersoonById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            System.out.println("LOG- REST: deletePersoonById/" + id + " - Niet gevonden.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("")
    public void deleteAllePersonen() {
        System.out.println("LOG- REST: personen - Aanroep van onze restserivce voor het deleten van alle personen.");
        service.deletePersonen();
    }
}

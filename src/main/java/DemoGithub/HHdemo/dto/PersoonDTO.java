package DemoGithub.HHdemo.dto;

import DemoGithub.HHdemo.model.Persoon;

public class PersoonDTO {
    private String naam;
    private String telefoonnummer;
    private String straat;
    private String woonplaats;

    public PersoonDTO(Persoon persoon) {
        setNaam(maakSamenGesteldeNaam(persoon));
        setTelefoonnummer(persoon.getTelefoonnummer());
        setWoonplaats(persoon.getWoonplaats());
        setStraat(persoon.getStraat());
    }

    private void setStraat(String straat) {
        this.straat = straat;
    }

    public String getStraat() {
        return straat;
    }

    private void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    private String maakSamenGesteldeNaam(Persoon persoon) {
        return (persoon.getVoornaam() + " " + persoon.getTussenvoegsel()).trim() + " " + persoon.getAchternaam();
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }
}

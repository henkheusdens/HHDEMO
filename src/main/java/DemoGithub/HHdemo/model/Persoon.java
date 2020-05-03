package DemoGithub.HHdemo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Entity
public class Persoon {

    @Id
    private Long id;
    @Column(unique = true)
    @Pattern(regexp = "^[0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]$")
    private String bsn;
    private String voornaam;
    private String tussenvoegsel;
    @NotEmpty(message ="Achternaam is verplicht. Graag invullen.")
    private String achternaam;
    private String telefoon;
    private String straat;
    private String huisnummer;
    private String postcode;
    private String woonplaats;

    private Persoon(){}

    public Persoon(Long id, String bsn, String voornaam, String tussenvoegsel, String achternaam, String telefoon, String straat, String huisnummer, String postcode, String woonplaats) {
        setId(id);
        setBsn(bsn);
        setVoornaam(voornaam);
        setTussenvoegsel(tussenvoegsel);
        setAchternaam(achternaam);
        setTelefoon(telefoon);
        setStraat(straat);
        setHuisnummer(huisnummer);
        setPostcode(postcode);
        setWoonplaats(woonplaats);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getBsn() {
        return bsn;
    }

    public void setBsn(String bsn) {
        this.bsn = bsn;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    public String getTelefoonnummer() {
        return telefoon;
    }
}

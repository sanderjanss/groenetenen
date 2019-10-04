package be.vdab.groenetenen.entities;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "offertes")
public class Offerte implements Serializable {
    public interface Stap1 {}
    public interface Stap2 {}
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(groups = Stap1.class)
    private String voornaam;
    @NotBlank(groups = Stap1.class)
    private String familienaam;
    @NotNull(groups = Stap1.class)
    @Email(groups = Stap1.class)
    private String emailAdres;
    @NotNull(groups = Stap2.class)
    @Positive(groups = Stap2.class)
    @NumberFormat
    private Integer oppervlakte;
    @DateTimeFormat(style = "S-")
    private LocalDate aangemaakt = LocalDate.now();

    public long getId() {
        return id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public String getEmailAdres() {
        return emailAdres;
    }

    public Integer getOppervlakte() {
        return oppervlakte;
    }

    public LocalDate getAangemaakt() {
        return aangemaakt;
    }
}

package be.vdab.groenetenen.restservices;

import be.vdab.groenetenen.domain.Filiaal;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class FiliaalIdNaam {
    @XmlAttribute
    private long id;
    @XmlAttribute
    private String naam;
    FiliaalIdNaam() {} // JAXB heeft een default constructor nodig
    FiliaalIdNaam(Filiaal filiaal) {
        this.id = filiaal.getId();
        this.naam = filiaal.getNaam();
    }
}

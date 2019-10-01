package be.vdab.groenetenen.forms;

import be.vdab.groenetenen.constraints.Postcode;
import be.vdab.groenetenen.constraints.VanTotPostcodeFormVanKleinerDanOfGelijkAanTot;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@VanTotPostcodeFormVanKleinerDanOfGelijkAanTot
public class VanTotPostcodeForm {
    @NotNull
    @Postcode
    private final Integer van;

    @NotNull
    @Postcode
    private final Integer tot;

    public VanTotPostcodeForm(@NotNull @Range(min = 1000, max = 9999) Integer van, @NotNull @Range(min = 1000, max = 9999) Integer tot) {
        this.van = van;
        this.tot = tot;
    }

    public Integer getVan() {
        return van;
    }

    public Integer getTot() {
        return tot;
    }
}

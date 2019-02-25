package pl.coderslab.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name="mainCovers")
public class MainCover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = " Podaj nazwę umowy głównej ! ")
    private String name;

    @NotBlank(message = " Podaj opis umowy głównej ! ")
    private String description;

    @NotNull(message = "Podaj wysokość rocznej składki za umowę ! ")
    @Digits(integer = 4, fraction = 0, message = "Podaj liczbę całkowitą - max 4 cyfry! ")
    private BigDecimal premium;

    @NotNull(message = "Podaj wysokość sumy ubezpieczenia ! ")
    @Digits(integer = 6, fraction = 0, message = "Podaj liczbę całkowitą - max 6 cyfr ! ")
    private BigDecimal sumAssured;

    @NotNull(message = "Podaj wysokość rocznej stawki prowizji 0.XX ! ")
    @Digits(integer = 0, fraction = 2)
    private BigDecimal commission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public BigDecimal getSumAssured() {
        return sumAssured;
    }

    public void setSumAssured(BigDecimal sumAssured) {
        this.sumAssured = sumAssured;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }
}

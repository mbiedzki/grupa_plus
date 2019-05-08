package pl.coderslab.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Wybierz ubezpieczonego")
    @OneToOne
    private User insured;

    @NotNull(message = "Wybierz uposażonego")
    @OneToOne
    private User beneficiary;

    @NotNull(message = "Wybierz grupę")
    @OneToOne
    private Group contractGroup;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "closed")
    private LocalDateTime closed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getInsured() {
        return insured;
    }

    public void setInsured(User insured) {
        this.insured = insured;
    }

    public User getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(User beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Group getContractGroup() {
        return contractGroup;
    }

    public void setContractGroup(Group contractGroup) {
        this.contractGroup = contractGroup;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getClosed() {
        return closed;
    }

    public void setClosed(LocalDateTime closed) {
        this.closed = closed;
    }

    @Override
    public String toString() {
        return "Umowa{" +
                "Nr umowy=" + id +
                ", Grupa=" + contractGroup +
                '}';
    }
}

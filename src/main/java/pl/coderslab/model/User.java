package pl.coderslab.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.pl.PESEL;
import pl.coderslab.util.BCrypt;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="users")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = " Podaj imię ! ")
        private String firstName;

        @NotBlank(message = " Podaj nazwisko ! ")
        private String lastName;

        @PESEL(message = " Podaj poprawny PESEL ! ")
        private String pesel;

        @NotNull
        @OneToOne(cascade = CascadeType.ALL)
        private Address address;

        @ColumnDefault("false")
        private boolean hasCorrAddress;

        @OneToOne(cascade = CascadeType.ALL)
        private Address corrAddress;

        @NotBlank
        @Pattern(message = " Podaj nr telefonu w formacie +48XXXXXXXXX ! ", regexp="/^\\+48\\d{9}$/")
        private String phone;

        @Email(message = " Podaj poprawny adres email ! ")
        private String email;

        private String password;

        private boolean isInsured;

        private boolean isBeneficiary;

        private boolean isHR;

        private boolean isAgent;

        private boolean agreedGPRD;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isHasCorrAddress() {
        return hasCorrAddress;
    }

    public void setHasCorrAddress(boolean hasCorrAddress) {
        this.hasCorrAddress = hasCorrAddress;
    }

    public Address getCorrAddress() {
        return corrAddress;
    }

    public void setCorrAddress(Address corrAddress) {
        this.corrAddress = corrAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isInsured() {
        return isInsured;
    }

    public void setInsured(boolean insured) {
        isInsured = insured;
    }

    public boolean isBeneficiary() {
        return isBeneficiary;
    }

    public void setBeneficiary(boolean beneficiary) {
        isBeneficiary = beneficiary;
    }

    public boolean isHR() {
        return isHR;
    }

    public void setHR(boolean HR) {
        isHR = HR;
    }

    public boolean isAgent() {
        return isAgent;
    }

    public void setAgent(boolean agent) {
        isAgent = agent;
    }

    public boolean isAgreedGPRD() {
        return agreedGPRD;
    }

    public void setAgreedGPRD(boolean agreedGPRD) {
        this.agreedGPRD = agreedGPRD;
    }

    public String getPassword() {
        return password;
    }

    //************************************************************************
    //password salted with BCrypt class
    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
        }


}

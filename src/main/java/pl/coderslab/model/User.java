package pl.coderslab.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.pl.PESEL;
import pl.coderslab.util.BCrypt;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = " Podaj imię ! ")
    private String firstName;

    @NotBlank(message = " Podaj nazwisko ! ")
    private String lastName;

    @NotNull(message = "Wybierz firmę !")
    @OneToOne
    private Company company;

    @PESEL(message = " Podaj poprawny PESEL ! ")
    private String pesel;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval=true)
    @Valid
    private Address address;

    @NotBlank(message = "Pole nie może być puste")
    @Pattern(message = " Podaj nr telefonu w formacie +48XXXXXXXXX ! ", regexp = "^\\+48\\d{9}$")
    private String phone;

    @NotBlank(message = "Pole nie może być puste")
    @Email(message = " Podaj poprawny adres email ! ")
    private String email;

    private String password;

    @ColumnDefault("false")
    private boolean insured;

    @ColumnDefault("false")
    private boolean beneficiary;

    @ColumnDefault("false")
    private boolean hr;

    @ColumnDefault("false")
    private boolean agent;

    @ColumnDefault("false")
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

    public String getFullName() {
        return lastName+" "+firstName; }

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    public boolean isBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(boolean beneficiary) {
        this.beneficiary = beneficiary;
    }

    public boolean isHr() {
        return hr;
    }

    public void setHr(boolean hr) {
        this.hr = hr;
    }

    public boolean isAgent() {
        return agent;
    }

    public void setAgent(boolean agent) {
        this.agent = agent;
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


    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

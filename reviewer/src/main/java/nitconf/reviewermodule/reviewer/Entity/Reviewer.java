package nitconf.reviewermodule.reviewer.Entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;


@Entity
@Table
public class Reviewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="first_name", nullable = false)
    private String firstName;
    @Column(name="middle_name", nullable= true)
    private String middleName;
    @Column(name="last_name", nullable = true)
    private String lastName;
    @Column(name="phone_no", nullable = true)
    private Long phoneNo;
    @ElementCollection
    @CollectionTable(name="reviewer_doi", joinColumns = @JoinColumn(name ="reviewer_id", referencedColumnName = "Id" ))
    @Column(name ="domain", nullable =true)
    private List <String> domainsOfInterest;

    @Column(name= "educationlevel", nullable = true)
    private String educationLevel;

    @Column(name="email", nullable= false)
    private String email;

    @Column(name="password", nullable= false)
    private String password;

    
    public Reviewer() {
    }


    public Reviewer(String firstName, String middleName, String lastName, Long phoneNo, List<String> domainsOfInterest,
            String educationLevel, String email, String password) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.domainsOfInterest = domainsOfInterest;
        this.educationLevel = educationLevel;
        this.email = email;
        this.password = password;
    }


    public Long getId() {
        return Id;
    }


    public void setId(Long id) {
        Id = id;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getMiddleName() {
        return middleName;
    }


    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Long getPhoneNo() {
        return phoneNo;
    }


    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }


    public List<String> getDomainsOfInterest() {
        return domainsOfInterest;
    }


    public void setDomainsOfInterest(List<String> domainsOfInterest) {
        this.domainsOfInterest = domainsOfInterest;
    }


    public String getEducationLevel() {
        return educationLevel;
    }


    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    



    








    
}

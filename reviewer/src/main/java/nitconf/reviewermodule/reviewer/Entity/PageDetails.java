package nitconf.reviewermodule.reviewer.Entity;

@Entity
@Table(name="paperdetail")
public class PageDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long PaperID;
    @Column(name="domain_of_paper", nullable=false)
    private String DomainOfPaper;
    
    public PageDetails(){}

    public PageDetails(String domainOfPaper) {
        DomainOfPaper = domainOfPaper;
    }

    public long getPaperID() {
        return PaperID;
    }

    public void setPaperID(int paperID) {
        PaperID = paperID;
    }

    public String getDomainOfPaper() {
        return DomainOfPaper;
    }

    public void setDomainOfPaper(String domainOfPaper) {
        DomainOfPaper = domainOfPaper;
    }
    

    

}

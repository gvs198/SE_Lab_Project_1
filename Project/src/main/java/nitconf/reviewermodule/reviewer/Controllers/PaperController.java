package nitconf.reviewermodule.reviewer.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nitconf.reviewermodule.reviewer.Entities.Paper;
import nitconf.reviewermodule.reviewer.Entities.ReviewedPapers;
import nitconf.reviewermodule.reviewer.Repositories.PaperRepository;
import nitconf.reviewermodule.reviewer.Service.PaperService;

@RestController
@RequestMapping("/papers")
public class PaperController {


    @Autowired
    private PaperService paperService;

    @GetMapping("/assignedpapers/{userid}")
    public List<Paper> assignedpapers(@PathVariable String userid)
    {
        return paperService.assignedPapers(userid);
    }
    
    @GetMapping("/reviewedpapers/{userid}")
    public List<ReviewedPapers> reviewedpapers(@PathVariable String userid)
    {
        return paperService.reviewedPapers(userid);
    }


}

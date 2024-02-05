package nitconf.reviewermodule.reviewer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nitconf.reviewermodule.reviewer.Repository.PageDetailRepository;

import java.util.*;

@Service
public class PageService {
	@Autowired
	private PageDetailRepository page;
	

	public List<PageDetailRepository> getPageDetail(){
		return page.findAll();
	}
}

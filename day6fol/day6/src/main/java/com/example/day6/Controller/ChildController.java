package com.example.day6.Controller;



import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day6.Entity.Child;
import com.example.day6.Service.ChildService;

@RestController
public class ChildController {
    @Autowired
	ChildService childservice;
	@PostMapping("addbaby")
	public List<Child> add(@RequestBody List<Child> childentity)
	{
		return childservice.saveinfo(childentity);
	}
	@GetMapping("showbaby")
	public List<Child> show()
	{
		return childservice.showinfo();
	} 
	@GetMapping("show/{id}")
	public Optional<Child> showparent(@PathVariable int id)
    {
		return childservice.getbyid(id);
	}
	@GetMapping("sort/{fname}")
	public List<Child> getsortinfo(@PathVariable String fname)
	{
		return childservice.sortinfo(fname);
	}
	@GetMapping("paging/{pageno}/{pagesize}")
	public List<Child> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize)
	{
		return childservice.getbypage(pageno, pagesize);
	}
}
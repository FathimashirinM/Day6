package com.example.day6.Service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day6.Entity.Child;
import com.example.day6.Repository.ChildRepository;

@Service
public class ChildService {

	@Autowired
    ChildRepository childrepository;
	
	public List<Child> saveinfo(List<Child> childentity)
	{
		return (List<Child>)childrepository.saveAll(childentity);
	}
	public List<Child> showinfo()
	{
		return childrepository.findAll();
	}
	public Child changeinfo(Child childentity)
	{
		return childrepository.saveAndFlush(childentity);
	}
	public void delete(Child childentity)
	{
		childrepository.delete(childentity);
	}
	public Optional<Child> getbyid(int id)
	{
		return childrepository.findById(id);
	}
	public List<Child> sortinfo(String s)
	{
		return childrepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
	}
	public List<Child> getbypage(int pgno,int pgsize)
	{
		Page<Child> p=childrepository.findAll(PageRequest.of(pgno, pgsize));
		return p.getContent();
	}
}
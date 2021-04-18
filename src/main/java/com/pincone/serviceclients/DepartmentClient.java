package com.pincone.serviceclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pinecone.user.vo.Department;

@FeignClient("DEPARTMENT-SERVICE")
public interface DepartmentClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/departments/{departmentId}")
	Department getDepartmentById(@PathVariable("departmentId") Long departmentId);
	
	@RequestMapping(method = RequestMethod.GET, value = "/departments/")
	List<Department> getDepartments();
	
}

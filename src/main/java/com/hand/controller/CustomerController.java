package com.hand.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hand.pojo.Address;
import com.hand.pojo.Customer;
import com.hand.service.AddressService;
import com.hand.service.CustomerService;
import com.hand.util.PageUtil;


@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AddressService addressService;
	
	@RequestMapping("login")
	public String login(Model model,HttpSession session,String username,String password) throws Exception{
		boolean b=customerService.login(username, password);
		if(b){
			session.setAttribute("username", username);
			return "redirect:index.jsp";
		}
		model.addAttribute("error", "用户名或密码错误!");
		return "login";
	}
	
	@RequestMapping("customerListPage")
	public @ResponseBody String customerListPage(Model model,int curpage) throws Exception{
		PageUtil<Customer> cpage=null;
		cpage=customerService.queryCustomerByPage(curpage);
		List<Customer> clist=cpage.getData();
		String json="";
		JsonObject jo=new JsonObject();
		jo.addProperty("curpage", cpage.getCurPage());
		jo.addProperty("pages", cpage.getPages());
		//JsonArray ja=new JsonArray();
		JsonArray ja=new JsonArray();
		for(Customer c:clist){
			JsonObject jo1=new JsonObject();
			jo1.addProperty("first_name", c.getFirstName());
			jo1.addProperty("last_name", c.getLastName());
			jo1.addProperty("address", c.getAddress());
			jo1.addProperty("email", c.getEmail());
			jo1.addProperty("customerid", c.getCustomerId());
			jo1.addProperty("lastupdate", c.getLastUpdate().toString());
			ja.add(jo1);
		}
		jo.add("customers", ja);
		json=jo.toString();			
		return json;
	}
	
	@RequestMapping("addcustomer1")
	public String insertCustomer1(Model model)throws Exception{
		List<Address> addresslist=addressService.getAllAddress();
		model.addAttribute("addresslist", addresslist);
		return "add";
	}
	
	@RequestMapping("addcustomer2")
	public String insertCustomer2(Model model,Customer customer)throws Exception{
		if(customer.getFirstName()==null||"".equals(customer.getFirstName())||customer.getLastName()==null||"".equals(customer.getLastName())||customer.getEmail()==null||"".equals(customer.getEmail())){
			model.addAttribute("addErr", "字段不能为空");
			return "forward:addcustomer1.do";
		}
		customer.setStoreId((byte)1);//数据库该字段不能为空，赋默认值1
		customer.setCreateDate(new Date());
		customer.setLastUpdate(new Date());
		boolean b=customerService.insertCustomer(customer);
		String msg="添加失败";
		if(b){
			msg="添加成功";
		}
		model.addAttribute("msg", msg);
		return "msg";
	}
	
	@RequestMapping("edit1")
	public String getCustomer(Model model,int customerId) throws Exception{
		
		Customer customer=customerService.queryCustomerById(customerId);		
		//获得地址
		List<Address> addresslist=addressService.getAllAddress();
		
		model.addAttribute("customer", customer);
		model.addAttribute("addresslist", addresslist);
		return "editcustomer";
	}
	
	@RequestMapping("edit2")
	public String updateCustomer(Model model,int customerId,Customer customer) throws Exception{	
		boolean b=customerService.updateCustomerByid(customerId, customer);	
		String msg="修改失败";
		if(b){
			msg="修改成功";
		}
		model.addAttribute("msg", msg);
		return "msg";
	}
	
	
	@RequestMapping("delcustomer")
	public @ResponseBody boolean deleteCustomer(Model model,int customerId) throws Exception{
		boolean b=customerService.deleteCustomerById(customerId);
		return b;
	}
	
	@RequestMapping("logout")
	public String logout(Model model,HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:index.jsp";
	}
	
}

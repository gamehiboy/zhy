package com.sibu.xinweishang.api.user;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sibu.xinweishang.api.model.User;
import com.sibu.xinweishang.api.service.IUserService;
import com.sibu.xinweishang.common.data.ResponseUtil;
import com.sibu.xinweishang.common.util.StringUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Resource
	private IUserService userService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String list(Model model) {
		return ResponseUtil.data(userService.selectUsers());
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	@ResponseBody
	public String delete(@PathVariable int id) {
		/*if(userService.deleteUser(id) == 1) {
			return ResponseUtil.success("ɾ���ɹ�");
		} else {
			return ResponseUtil.error("ɾ��ʧ��");
		}*/
		return null;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@ResponseBody
	public String update(@Validated User user, BindingResult br) {
		if(br.hasErrors()) {
			return ResponseUtil.error("δ֪����");
		}
		if(userService.updateUser(user) == 1) {
			return ResponseUtil.success("���³ɹ�");
		} else {
			return ResponseUtil.error("����ʧ��");
		}
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public String add(@Validated User user, BindingResult br) {
		if(br.hasErrors()) {
			return ResponseUtil.error("��������");
		}
		if(userService.addTableUser(user) == 1) {
			return ResponseUtil.success("��ӳɹ�");
		} else {
			return ResponseUtil.error("���ʧ��");
		}
	}
	
	@RequestMapping(value="/get/{userId}", method=RequestMethod.GET)
	@ResponseBody
	public String get(@PathVariable String userId, Model model) {
		User user = userService.getTableUser(userId);
		if(StringUtil.isNull(user)) {
			return ResponseUtil.error("δ��ѯ������");
		} else {
			return ResponseUtil.data(user);
		}
	}
}

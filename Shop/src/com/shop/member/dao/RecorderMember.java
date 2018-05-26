package com.shop.member.dao;

import com.shop.base.dao.Recorder;
import com.shop.member.model.Member;
import com.shop.role.dao.RecorderRole;
import com.shop.role.model.Role;
import com.shop.user.dao.RecorderUser;
import com.shop.user.model.User;

public class RecorderMember extends Recorder{
	public static boolean addMember(Member member) {
		return RecorderUser.addUser(member.getUser())&&RecorderRole.addRole(member.getUser(), member.getRole());
	}
	public static boolean deleteMember(Member member) {
		String userID=member.getUser().getId();
		return RecorderUser.deleteUser(userID)&&RecorderRole.deleteRole(userID);
	}
	public static Member getMember(String userID) {
		Member member=null;
		User user=null;
		Role role=null;
		user=RecorderUser.getUser(userID);
		role=RecorderRole.getRole(userID);
		if(user!=null&&role!=null) {
			member=new Member();
			member.setUser(user);
			member.setRole(role);
		}
		return member;
	}
	public static boolean alterMember(Member member) {
		User user=member.getUser();
		Role role=member.getRole();
		return RecorderUser.alterUser(user)&&RecorderRole.alterRole(user.getId(), role);
	}
}
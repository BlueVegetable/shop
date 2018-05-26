package com.shop.member.service;

import com.shop.member.dao.RecorderMember;
import com.shop.member.model.Member;

public class Experiecne {
	public static void main(String[] args) {
		Member member=RecorderMember.getMember("1000000003");
		System.out.println(member);
	}
}
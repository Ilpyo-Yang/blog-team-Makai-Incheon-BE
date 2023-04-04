package com.bms.blog.test;

import com.bms.blog.service.TagService;
import com.bms.blog.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class DefaultValueTests {
	@Autowired
	private UserService userService;
	@Autowired
	private TagService tagService;

	@Test
	@DisplayName("USER SAMPLE DATA")
	@Rollback(false)
	void insertUserDate() {
		//userService.setUser(null, "레이머", "$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi", "ROLE_USER");
		userService.setUser(null, "rosie", "$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi", "ROLE_USER");
		userService.setUser(null, "영민", "$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi", "ROLE_USER");
	}

	@Test
	@DisplayName("TAG SAMPLE DATA")
	@Rollback(false)
	void insertTagDate() {
		tagService.setTag("블로그");
		tagService.setTag("개발자");
		tagService.setTag("회고");
	}

}

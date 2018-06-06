package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.UserInfo;
import com.example.demo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringWebApplicationTests {

	@Inject
	UserService sr;

	@Test
	public void contextLoads() {
		// //保存测试
		// User user = new User("4552", "京沪高", 22, "女", "534535@163.com", "下棋");
		// sr.persist(user);

		// // 查询
		// User user2=sr.find("9999");
		// System.out.println(user2);

		// // 修改
		// sr.merge("1001", "李雷雷");

		// // 删除
		// sr.remove("1001");

		List<UserInfo> list = new ArrayList<>();
		int page = 2;
		list = sr.sel(page);
		System.out.printf("第%d页数据：\n", page);
		for (UserInfo user : list) {
			System.out.println(user + "\n");
		}

	}

}

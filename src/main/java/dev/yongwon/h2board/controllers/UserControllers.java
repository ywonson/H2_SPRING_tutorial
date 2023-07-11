package dev.yongwon.h2board.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;


@Controller
public class UserControllers {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @GetMapping("/getUser")
    public String userPage(Model model) {
        List<Map<String, Object>> users = jdbcTemplate.queryForList("SELECT u.user_id, groupname, username, email\r\n"
        		+ "FROM users u\r\n"
        		+ "LEFT JOIN usergroup_assignment uga  ON u.user_id= uga.user_id\r\n"
        		+ "LEFT JOIN usergroup ug ON ug.group_id = uga.group_id;");
        model.addAttribute("users", users);
        for (Map<String, Object> user : users) {
        	String groupName = (String) user.get("groupname");
            String userName = (String) user.get("username");
            String eMail = (String) user.get("email");

            System.out.println("GN: " + groupName + ", N: " + userName + ", Email: " + eMail);
        }
        return "dynamicUsers";
    }


}

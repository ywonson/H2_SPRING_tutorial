package dev.yongwon.h2board.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.sql.Timestamp;

@Controller
public class BoardControllers {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/getContent")
    public String boardPage(Model model) {
        List<Map<String, Object>> boards = jdbcTemplate.queryForList("SELECT GROUP_CONCAT(ug.groupname SEPARATOR ', ') AS groups,  u.username, b.content, b.created_date, b.modified_date\r\n"
        		+ "FROM board b\r\n"
        		+ "LEFT JOIN users u ON u.user_id = b.author\r\n"
        		+ "LEFT JOIN usergroup_assignment uga ON u.user_id = uga.user_id\r\n"
        		+ "LEFT JOIN usergroup ug ON ug.group_id = uga.group_id\r\n"
        		+ "GROUP BY board_id\r\n"
        		+ "ORDER BY b.created_date DESC");
        model.addAttribute("boards", boards);
        for (Map<String, Object> board : boards) {
        	String userName = (String) board.get("username");
            String groups = (String) board.get("groups");
            String content = (String) board.get("content");
            Timestamp createdDate = (Timestamp) board.get("created_date");
            Timestamp modifiedDate = (Timestamp) board.get("modified_date");
            System.out.println("userName: " + userName + ", groups: " + groups + ", Content: " + createdDate);
        }
        return "dynamicContent";
    }
    

}

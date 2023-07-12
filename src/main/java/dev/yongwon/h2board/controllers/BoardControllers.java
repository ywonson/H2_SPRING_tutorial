package dev.yongwon.h2board.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Date;
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
            Timestamp createdDate = (Timestamp) board.get("created_date");
            System.out.println("userName: " + userName + ", groups: " + groups + ", Content: " + createdDate);
        }
        return "dynamicContent";
    }
    
    @PostMapping("/addBoard")
    public ResponseEntity<String> addBoard(@RequestParam("username") String username,
                                           @RequestParam("content") String content) {
        try {
            // Find the author ID by name
            String sql = "SELECT user_id FROM users WHERE username = ?";
            Map<String, Object> result = jdbcTemplate.queryForMap(sql, username);
            int authorId = (int) result.get("user_id");
            
            // Insert the board data
            Timestamp currentTime = new Timestamp(new Date().getTime());
            jdbcTemplate.update("INSERT INTO board (content, author, created_date, modified_date) VALUES (?, ?, ?, ?)",
                                content, authorId, currentTime, currentTime);
            
            return ResponseEntity.ok("Board writing successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while inserting user data: " + e.getMessage());
        }
    }
    

}

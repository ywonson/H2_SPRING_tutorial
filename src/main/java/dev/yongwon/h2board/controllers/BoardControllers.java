package dev.yongwon.h2board.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
//import java.time.LocalDate; 
import java.sql.Timestamp;
@Controller
public class BoardControllers {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/board")
    public String boardPage(Model model) {
        List<Map<String, Object>> boards = jdbcTemplate.queryForList("SELECT * FROM board");
        model.addAttribute("boards", boards);
        for (Map<String, Object> board : boards) {
            int id = (int) board.get("board_id");
            String content = (String) board.get("content");
            Timestamp createdDate = (Timestamp) board.get("created_date");

            System.out.println("ID: " + id + ", Title: " + content + ", Content: " + createdDate);
        }
        return "board";
    }
}

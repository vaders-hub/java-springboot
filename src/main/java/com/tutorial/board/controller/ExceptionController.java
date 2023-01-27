package com.tutorial.board.controller;

import com.tutorial.board.exception.BoardNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
public class ExceptionController {
    @RequestMapping("/boardError")
    public String boardError() {
        throw new BoardNotFoundException("no board");
    }

    @RequestMapping("/illegalArgumentError")
    public String ellegalArgumentError() {
        throw new IllegalArgumentException("arg Error");
    }

    @RequestMapping("/sqlError")
    public String sqlError() throws SQLException {
        throw new SQLException("SQL Error");
    }
}

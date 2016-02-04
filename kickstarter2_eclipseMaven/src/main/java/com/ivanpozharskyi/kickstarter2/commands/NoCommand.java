package com.ivanpozharskyi.kickstarter2.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ivanpozharskyi.kickstarter2.manager.ConfigurationManager;

public class NoCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response){
   
        String page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.LOGIN_PAGE_PATH);
        return page;
    }

}

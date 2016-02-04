package com.ivanpozharskyi.kickstarter2.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpRequest;

import com.ivanpozharskyi.kickstarter2.commands.AddProjectCommand;
import com.ivanpozharskyi.kickstarter2.commands.CategoriesCommand;
import com.ivanpozharskyi.kickstarter2.commands.Command;
import com.ivanpozharskyi.kickstarter2.commands.DeleteProjectCommand;
import com.ivanpozharskyi.kickstarter2.commands.LoginCommand;
import com.ivanpozharskyi.kickstarter2.commands.LogoutCommand;
import com.ivanpozharskyi.kickstarter2.commands.NoCommand;
import com.ivanpozharskyi.kickstarter2.commands.ProjectsCommand;
import com.ivanpozharskyi.kickstarter2.commands.RegistrationCommand;
import com.ivanpozharskyi.kickstarter2.commands.ShowProjectInfo;
import com.ivanpozharskyi.kickstarter2.commands.ToRegistration;

public class RequestHelper {
	private static RequestHelper instance = null;
	private Map<String,Command> commands = new HashMap<>();
	
	private RequestHelper(){
		commands.put("login", new LoginCommand());
		commands.put("categories", new CategoriesCommand());
		commands.put("projects", new ProjectsCommand());
		commands.put("showProjectInfo", new ShowProjectInfo());
		commands.put("registration", new RegistrationCommand());
		commands.put("NoCommand", new NoCommand());
		commands.put("toRegistration", new ToRegistration());
		commands.put("addProjectInCategory", new AddProjectCommand());
		commands.put("deleteProject",new DeleteProjectCommand());
		
		commands.put("logout", new LogoutCommand());
	}
	public static RequestHelper getInstance(){
		if(instance == null){
			instance = new RequestHelper();
		}
		return instance;
	}
	public Command readCommand(HttpServletRequest request){
		Command command = null;
		command = commands.get(request.getParameter("command"));
		if(command == null){
			command = new NoCommand();
		}
		return command;
	}
}

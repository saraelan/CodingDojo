package com.codingdojo.web.controller.team;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codingdojo.model.Player;
import com.codingdojo.model.Roster;
import com.codingdojo.model.team;
/**
 * Servlet implementation class Team
 */
@WebServlet("/Team")
public class Team extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Team() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//session.getAttribute("players");
		session.getAttribute("players");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/NewTeam.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String name = request.getParameter("tname");
		team t = new team(name); 
		String teamName = t.getTeamName();
		Roster.allTeams.add(t);
		System.out.println(teamName);
	
		
		session.setAttribute("team", t);
		session.setAttribute("name", teamName);
		response.sendRedirect("/TeamRoster/Home");
		//doGet(request, response);
	}

}

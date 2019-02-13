package com.codingdojo.web.controller.team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codingdojo.model.Player;
import com.codingdojo.model.Roster;

/**
 * Servlet implementation class TeamInfo
 */
@WebServlet("/teamInfo")
public class TeamInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Integer teamId = Integer.valueOf(request.getParameter("id"));
		String tName = (String)session.getAttribute("name");
		System.out.println(tName);
		//ArrayList<Player> p = Roster.allTeams.get(teamId).getPlayers();
		//System.out.println("the size is "+p.size());
		if(teamId == null) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/TeamInfo.jsp");
			System.out.println("Team id is null");
			view.forward(request, response);
		}else {
			
		session.setAttribute("tname", tName);
		session.setAttribute("teamplayers", Roster.allTeams.get(teamId));
		session.setAttribute("teamId", teamId);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/TeamInfo.jsp");
		view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.codingdojo.web.controller.team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
 * Servlet implementation class Players
 */
@WebServlet("/Players")
public class Players extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Players() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String tName = (String)session.getAttribute("name");
		session.setAttribute("tname", tName);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/NewPlayer.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 HashMap<String,ArrayList<Player>> m = new HashMap<String,ArrayList<Player>>();
    // ArrayList<Player>  numoFplayers = new ArrayList<Player>();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		int age = Integer.parseInt(request.getParameter("age"));
		Player p = new Player(fname,lname,age);
		
		HttpSession session = request.getSession();
		int id = Integer.valueOf((String) request.getAttribute("teamId"));
		ArrayList<Player> player = Roster.allTeams.get(id).getPlayers();
	    player.add(p);	
		team t = (team) session.getAttribute("team");
	    String team = (String)session.getAttribute("tname");
	
	    
	    System.out.println("Am in players and the size is "+player.size());
	   
	   
	    session.setAttribute("tplayers", player);
	    session.setAttribute("teamId", id);
	    session.setAttribute("name",team);
		response.sendRedirect("/TeamRoster/TeamInfo");
	}

}

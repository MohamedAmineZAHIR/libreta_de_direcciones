package zma;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;


/**
 * Servlet implementation class Controler
 */
@WebServlet("/Controler")
public class Controler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public PrintWriter out;
	public Model model = new Model();
	
	/**
	 * Default constructor. 
	 */
	public Controler() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//super.doGet(request, response);
		response.setContentType("text/html");
		out = response.getWriter();
		
		switch (request.getParameter("submit")) {
		case "Enregistrer":
			model.save_contact(request.getParameter("first_name"), 
					request.getParameter("family_name"), 
					request.getParameter("adress"), 
					request.getParameter("phone"));
			
			response.sendRedirect("index.html");
			break;
			
		case "Chercher":
			request.setAttribute("contacts", model.find_contact(request.getParameter("first_name"), request.getParameter("family_name")));
			request.getServletContext().getRequestDispatcher("/show_contacts.jsp").forward(request,response);
			break;
			
		case "Mise à jour":
			model.update(request.getParameter("first_name"), request.getParameter("family_name"), 
					request.getParameter("column"), request.getParameter("value"));
			response.sendRedirect("index.html");
			break;
		
		case "Supprimer":
			model.delete(request.getParameter("first_name"), request.getParameter("family_name"));
			response.sendRedirect("index.html");
			
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//super.doPost(request, response);

		response.setContentType("text/html");
		out = response.getWriter();

		switch (request.getParameter("carnet")) {
		case "save":
			response.sendRedirect("save.html");
			break;
		case "find":
			response.sendRedirect("find.html");
			break;
		case "list":
			request.setAttribute("contacts", model.contacts_list());
			request.getServletContext().getRequestDispatcher("/show_contacts.jsp").forward(request,response);
			break;
		case "update":
			response.sendRedirect("update.html");
			break;
		case "delete":
			response.sendRedirect("delete.html");
		default:
			out.print("<h1>404 ^^</h1>");
			break;
		}
	}
	

}

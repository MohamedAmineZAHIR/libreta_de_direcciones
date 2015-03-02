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
		
		String choice = request.getParameter("submit");
		
		switch (choice) {
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
			
			break;
			
		default:
			break;
		}
		
		out.println("Choice " + choice);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//super.doPost(request, response);

		response.setContentType("text/html");
		out = response.getWriter();

		String choix = request.getParameter("carnet");
		out.println("Choix " + choix);

		switch (choix) {
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
		default:
			out.print("<h1>404 ^^</h1>");
			break;
		}
	}
	

}

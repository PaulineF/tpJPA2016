package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.*;
import domain.*;

@WebServlet(name="userinfo", urlPatterns={"/UserInfo"})
public class UserInfo extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PersonService personServ = new PersonServiceImpl();
		PrintWriter out = response.getWriter();

		//GET JSON
		out.println(personServ.getPerson());
		
		//GET html
		 /* out.println("<HTML>\n<BODY>\n" +
				"<H1>Recapitulatif des informations</H1>\n" +
				"\n" );

		for (Person pers : personServ.getPerson()){
			out.println(" <UL><LI>Nom: "
					+ pers.getFirstName() + "\n" +
					" <LI>Prenom: "
					+ pers.getLastName() + "\n" +
					" <LI>Mail: "
					+ pers.getMail() + "</hr></UL>" );
		}


		out.println(
				"\n" +                
				"</BODY></HTML>");*/
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String name = request.getParameter("name");
		String firstname = request.getParameter("firstname");
		String mail = request.getParameter("mail");

		PersonService personServ = new PersonServiceImpl();

		personServ.addPerson(firstname, name, mail);

		PrintWriter out = response.getWriter();
		out.println("<HTML>\n<BODY>\n" +
				"<H1>Recapitulatif des informations</H1>\n" +
				"\n" );
		for (Person pers : personServ.getPerson()){
			out.println(" <UL><LI>Nom: "
					+ pers.getFirstName() + "\n" +
					" <LI>Prenom: "
					+ pers.getLastName() + "\n" +
					" <LI>Mail: "
					+ pers.getMail() + "</hr></UL>" );
		}

		out.println(
				"\n" +                
				"</BODY></HTML>");
	}
}

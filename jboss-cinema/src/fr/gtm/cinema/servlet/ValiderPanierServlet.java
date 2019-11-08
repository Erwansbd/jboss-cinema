package fr.gtm.cinema.servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * Servlet implementation class ValiderPanierServlet
 */
@WebServlet("/ValiderPanierServlet")
public class ValiderPanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILENAME = "C:\\templates-html\\template.html";
	public static final Logger tchikita = Logger.getLogger("Cinema");
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		String strCurrentLine;
		BufferedReader bufferedreader = null;
		FileReader filereader = null;
		List<String> temp = new ArrayList<String>();
		try {
		      filereader = new FileReader(FILENAME);
		      bufferedreader = new BufferedReader(filereader);
			while ((strCurrentLine = bufferedreader.readLine()) != null) {
				strCurrentLine = strCurrentLine.replace("{{numcom}}", "4269");
				strCurrentLine = strCurrentLine.replace("{{civilite}}", "Monsieur");
				strCurrentLine = strCurrentLine.replace("{{prenom}}", request.getParameter("prenom"));
				strCurrentLine = strCurrentLine.replace("{{nom}}", request.getParameter("nom"));
				temp.add(strCurrentLine);
				message = message.concat(strCurrentLine);
				System.out.println(message);
			}

		// Create the email message
		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("erwansbd@gmail.com", "Soube_stick"));
		email.setSSLOnConnect(true);
		email.addTo(request.getParameter("email"));
		email.setFrom("erwansbd@gmail.com");
		email.setSubject("Test mail");

		// set the html message
		email.setHtmlMsg(message);

		// set the alternative message
		email.setTextMsg("Your email client does not support HTML messages");

		// send the email
		email.setCharset("UTF-8");
		email.send();
		tchikita.info("Votre mail a été envoyé");
		

	}
		catch (IOException | EmailException e) {
		      e.printStackTrace();
		    } finally {
		      try {
		        if (bufferedreader != null)
		          bufferedreader.close();
		        if (filereader != null)
		          filereader.close();
		      } catch (IOException e) {
		        e.printStackTrace();
		      }
		    }
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

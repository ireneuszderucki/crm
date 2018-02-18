package pl.deruckiireneusz.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.deruckiireneusz.dao.CustomerDao;
import pl.deruckiireneusz.model.Customer;
import pl.deruckiireneusz.services.DbUtil;
import pl.deruckiireneusz.services.MultiHelper;


/**
 * Servlet implementation class EditCustomer
 */
@WebServlet("/EditCustomer")
public class EditCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection conn = DbUtil.getConn();
			int id = Integer.parseInt(request.getParameter("id"));
			Customer customer = CustomerDao.loadCustomerById(conn, id);
			request.setAttribute("customer", customer);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/WEB-INF/views/EditCustomer.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection conn = DbUtil.getConn();
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name").trim();
			String surname = request.getParameter("surname").trim();
			String birthday = request.getParameter("birthday").trim();
				if (MultiHelper.atLeastThreeChars(name) &&
					MultiHelper.atLeastThreeChars(surname) &&
					MultiHelper.atLeastThreeChars(birthday)) {
					Customer customer = new Customer(name, surname, birthday);
					customer.setId(id);
					CustomerDao.saveCustomerToDB(conn, customer);
					response.sendRedirect("AllCustomers");
				}
				else {
					response.sendRedirect("EditCustomer?id=" + id);
				}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

}

package pl.deruckiireneusz.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.deruckiireneusz.dao.CustomerDao;
import pl.deruckiireneusz.model.Customer;
import pl.deruckiireneusz.services.DbUtil;



/**
 * Servlet implementation class AllCustomers
 */
@WebServlet("/AllCustomers")
public class AllCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllCustomers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection conn = DbUtil.getConn();
			ArrayList<Customer> customers = CustomerDao.loadAllCustomers(conn);
			if (customers.isEmpty()) {
				String defaultMsg = "No customers so far";
				request.setAttribute("defaultMsg", defaultMsg);
			}
			else {
				request.setAttribute("customers", customers);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/WEB-INF/views/AllCustomers.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

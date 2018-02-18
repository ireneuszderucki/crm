package pl.deruckiireneusz.controller.employee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.deruckiireneusz.dao.EmployeeDao;
import pl.deruckiireneusz.model.Employee;
import pl.deruckiireneusz.services.DbUtil;

/**
 * Servlet implementation class DeleteCustomer
 */
@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmployee() {
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
			Employee employee = EmployeeDao.loadEmployeeById(conn, id);
			request.setAttribute("employee", employee);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/WEB-INF/views/DeleteEmployee.jsp")
		.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection conn = DbUtil.getConn();
			int id = Integer.parseInt(request.getParameter("id"));
			String yes = request.getParameter("yes");
			if (yes != null) {
				Employee employee = EmployeeDao.loadEmployeeById(conn, id);
				EmployeeDao.deleteEmployee(conn, employee);
				response.sendRedirect("AllEmployees");
			}
			else {
				response.sendRedirect("AllEmployees");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

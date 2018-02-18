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
import pl.deruckiireneusz.services.MultiHelper;


/**
 * Servlet implementation class EditCustomer
 */
@WebServlet("/EditEmployee")
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployee() {
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
		getServletContext().getRequestDispatcher("/WEB-INF/views/EditEmployee.jsp")
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
			String address = request.getParameter("address").trim();
			String cellNo = request.getParameter("cellNo").trim();
			String notice = request.getParameter("notice").trim();
			Double manHourCost = Double.parseDouble(request.getParameter("manHourCost"));
				if (MultiHelper.atLeastThreeChars(name) &&
					MultiHelper.atLeastThreeChars(surname) &&
					MultiHelper.atLeastThreeChars(address) &&
					MultiHelper.atLeastThreeChars(cellNo) &&
					MultiHelper.atLeastThreeChars(notice) &&
					manHourCost > 0) {
					Employee employee= new Employee(name, surname, address, cellNo, notice, manHourCost);
					employee.setId(id);
					EmployeeDao.saveEmployeeToDB(conn, employee);
					response.sendRedirect("AllEmployees");
				}
				else {
					response.sendRedirect("EditEmployee?id=" + id);
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

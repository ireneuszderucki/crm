package pl.deruckiireneusz.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.deruckiireneusz.dao.VehicleDao;
import pl.deruckiireneusz.model.Vehicle;
import pl.deruckiireneusz.services.DbUtil;

/**
 * Servlet implementation class CustomerVehicleList
 */
@WebServlet("/CustomerVehicleList")
public class CustomerVehicleList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerVehicleList() {
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
			ArrayList<Vehicle> vehicles = VehicleDao.loadAllVehiclesByCustomerId(conn, id);
			if (vehicles.isEmpty()) {
				String defaultMsg = "No vehicles assigned to the customer";
				request.setAttribute("defaultMsg", defaultMsg);
			}
			else {
				request.setAttribute("vehicles", vehicles);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/WEB-INF/views/CustomerVehicleList.jsp")
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

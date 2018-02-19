package pl.deruckiireneusz.controller.vehicle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.deruckiireneusz.dao.VehicleDao;
import pl.deruckiireneusz.model.Vehicle;
import pl.deruckiireneusz.services.DbUtil;
import pl.deruckiireneusz.services.MultiHelper;

/**
 * Servlet implementation class AddVehicle
 */
@WebServlet("/AddVehicle")
public class AddVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVehicle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/AddVehicle.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection conn = DbUtil.getConn();
			int customer_id = Integer.parseInt(request.getParameter("customer_id"));
			String model = request.getParameter("model").trim();
			String brand = request.getParameter("brand").trim();
			String productionY = request.getParameter("productionY").trim();
			String registrationNo = request.getParameter("registrationNo").trim();
			String nextInspectionDate = request.getParameter("nextInspectionDate").trim();
				if (MultiHelper.atLeastThreeChars(model) &&
					MultiHelper.atLeastThreeChars(brand) &&
					MultiHelper.atLeastThreeChars(productionY) &&
					MultiHelper.atLeastThreeChars(registrationNo) &&
					MultiHelper.atLeastThreeChars(nextInspectionDate)) {
					Vehicle vehicle = new Vehicle(customer_id, model, brand, productionY, registrationNo, nextInspectionDate);
					VehicleDao.saveVehicleToDB(conn, vehicle);
					response.sendRedirect("AllVehicles");
				}
				else {
					response.sendRedirect("AddVehicle");
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

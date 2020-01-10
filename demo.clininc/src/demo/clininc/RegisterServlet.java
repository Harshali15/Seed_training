package demo.clininc;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import demo.clininc.model.Patient;
import demo.clininc.model.Prescription;
import demo.clininc.model.Medicine;
import demo.clininc.model.PatientDao;
import demo.clininc.model.PrescriptionDao;
import demo.clininc.model.MedicineDao;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RegisterServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nm_del = request.getParameter("del_name").trim();
		String nm_edit = request.getParameter("edit_name").trim();
		System.out.println("Del name : "+nm_del);
		System.out.println(nm_del);
		System.out.println(nm_edit);
		
		if(request.getParameter("delBtn")!=null) {
			
		
			PatientDao.delete(nm_del);
			
		}
		else if(request.getParameter("editBtn")!=null) {
			
			//PatientDao.tblUpdate(nm_edit, "x@gmail.com");
		
		}
		
		List<Patient> patients = null;
		patients = PatientDao.display();
		
		
		
		request.setAttribute("patients", patients);
		
		request.getRequestDispatcher("page2.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String name = request.getParameter("name").trim();
		String email = request.getParameter("email").trim();
		int patientId = Integer.parseInt(request.getParameter("patientId"));
		
		System.out.println("ID : "+patientId);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy ");
		Date date = new Date();
		System.out.println("Hii"+date);
		System.out.println(formatter.format(date));

		  /*String str="10-01-2020";  
		  Date date=Date.valueOf(str);*/
		
		Patient patient = new Patient(patientId,name,email,date);
		PatientDao.create(patient);
		
		List<Patient> patients = null;
		patients = PatientDao.display();
		
		//StudentsDao.shutdown();
		
		request.setAttribute("patients",patients);
		
		request.getRequestDispatcher("register.jsp").forward(request, response);
		
	}

}
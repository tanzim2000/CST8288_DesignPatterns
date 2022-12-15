package viewlayer;

import businesslayer.BusinessLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.*;

/**
 *
 * @author Tanzim Ahmed Sagar
 */
@WebServlet(name = "CoursesSummeryView", urlPatterns = {"/CoursesSummeryView"})
public class CoursesSummeryView extends HttpServlet {

    private CredentialsDTO credentials = new CredentialsDTO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Courses Summery View</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet CoursesSummeryView at " + request.getContextPath() + "</h1>");
        credentials.setUsername(request.getParameter("username"));
        credentials.setPassword(request.getParameter("password"));
        BusinessLogic logic = new BusinessLogic(credentials);
        try{
            List<CourseDTO> courses = logic.getAllCourses();
            out.println("<table border=\"1\">");
            out.println("   <tr>");
            out.println("      <th>Course Code</td>");
            out.println("       <th>Course Name</td>");
            out.println("      <th>Description</td>");
            out.println("   </tr>");
            for(CourseDTO course : courses){
                out.println("   <tr>");
                out.println("       <td>");
                out.println("           " + course.getCourseCode());
                out.println("       </td>");
                out.println("       <td>");
                out.println("           " + course.getCourseName());
                out.println("       </td>");
                out.println("      <td>");
                out.println("           " + course.getCourseDescription());
                out.println("       </td>");
                out.println("   </tr>");
            }
            out.println("</table>");
        } catch (SQLException ex) {
            out.println("<center>");
            out.println(ex.getMessage());
            out.println("</center>");
        }
        out.println("</body>");
        out.println("</html>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet for retriving all course info.";
    }// </editor-fold>

}
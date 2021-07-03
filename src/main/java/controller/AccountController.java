package controller;

import dao.AccountDAO;
import model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AccountController", urlPatterns = "/list")
public class AccountController extends HttpServlet {
    private AccountDAO accountDAO;

    public void init() {
        accountDAO = new AccountDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null)
            action="";
        try {
            switch (action) {
                case "create": showCreatForm(request,response);break;
//                case "edit": showEditForm(request,response); break;
                case "view": viewAccount(request,response);break;
                default: accountList(request,response); break;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null)
            action="";
        try {
            switch (action) {
                case "create": insertAccount(request,response);accountList(request,response); break;
                case "edit": break;
                case "delete": break;
                default:accountList(request,response);break;
            }
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        }
    }

    private void accountList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Account> accountList = accountDAO.showAll();
        request.setAttribute("accounts",accountList);
        RequestDispatcher rd = request.getRequestDispatcher("account/list.jsp");
        rd.forward(request,response);
    }
    private void viewAccount(HttpServletRequest request,HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String userName = request.getParameter("userName");
        Account account = accountDAO.select(userName);
        request.setAttribute("account",account);
        RequestDispatcher rd = request.getRequestDispatcher("account/view.jsp");
        rd.forward(request,response);
    }
    private void showCreatForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("account/register.jsp");
        rd.forward(request,response);
    }

    private void insertAccount(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String userID = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String fullName = request.getParameter("fullName");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String avatar = request.getParameter("avatar");
        Account newAccount = new Account(userID,userPassword,fullName,dob,email,address,avatar);
        accountDAO.insertFullInfo(newAccount);
        RequestDispatcher rd = request.getRequestDispatcher("account/register.jsp");
        rd.forward(request,response);
    }
    private void createSimpleAccountForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException,IOException {

    }

}

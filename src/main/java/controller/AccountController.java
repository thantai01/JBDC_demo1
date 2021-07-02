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
                case "create": break;
                case "edit": break;
                case "delete": break;
                default: accountList(request,response); break;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void accountList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Account> accountList = accountDAO.showAll();
        request.setAttribute("accounts",accountList);
        RequestDispatcher rd = request.getRequestDispatcher("account/list.jsp");
        rd.forward(request,response);
    }
}

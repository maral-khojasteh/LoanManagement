package com.dotinschool.controller;

import com.dotinschool.model.bl.GrantConditionService;
import com.dotinschool.model.bl.LoanFileService;
import com.dotinschool.model.bl.LoanTypeService;
import com.dotinschool.model.bl.PersonService;
import com.dotinschool.model.to.LoanFile;
import com.dotinschool.model.to.LoanType;
import com.dotinschool.model.to.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Maral Khojasteh
 */
public class SubmitLoanFileServlet extends HttpServlet{

    private static Logger logger = LogManager.getLogger(SubmitLoanTypeServlet.class);

    private GrantConditionService grantConditionService;
    private LoanTypeService loanTypeService;
    private LoanFileService loanFileService;
    private PersonService personService;

    public SubmitLoanFileServlet(){
        grantConditionService = new GrantConditionService();
        loanTypeService = new LoanTypeService();
        loanFileService = new LoanFileService();
        personService = new PersonService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        logger.info("SubmitLoanFile Servlet Called!");

        String loanTypeId = request.getParameter("loan_type").trim();
        String customerId = request.getParameter("customer_id").trim();
        String contractAmount = request.getParameter("contract_amount").trim();
        String contractDuration = request.getParameter("contract_duration").trim();

        LoanType loanType = loanTypeService.findById(Long.valueOf(loanTypeId));
        Person person = personService.findById(Long.valueOf(customerId));
        List<LoanType> loanTypes = loanTypeService.findAll();
        request.setAttribute("loanTypes", loanTypes);

        boolean isFind = grantConditionService.find(loanType, Double.valueOf(contractAmount), Integer.valueOf(contractDuration));

        if(isFind){
            LoanFile loanFile = new LoanFile();
            loanFile.setAmount(Double.valueOf(contractAmount));
            loanFile.setDuration(Integer.valueOf(contractDuration));
            loanFile.setLoanType(loanType);
            loanFile.setPerson(person);
            loanFileService.save(loanFile);
            logger.info("Loan file saved successfully!");
            request.setAttribute("message", "پرونده تسهیلاتی با موفقیت ثبت شد");
            request.setAttribute("statusClass", "success");
            request.setAttribute("disabled", "disabled");
        }
        else{
            logger.error("There is no grant condition for this request");
            request.setAttribute("message", "برای این درخواست شرط اعطایی یافت نشد");
            request.setAttribute("statusClass", "error");
            request.setAttribute("disabled", "");
            request.setAttribute("customerNumber", person.getCustomerNumber());
            request.setAttribute("customerName", person.getFirstName() + " " + person.getLastName());
            request.setAttribute("customerId", customerId);
            request.setAttribute("amount", contractAmount);
            request.setAttribute("duration", contractDuration);
            request.setAttribute("selectedId", loanTypeId);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/loans_file.jsp");
        dispatcher.forward(request, response);

    }
}

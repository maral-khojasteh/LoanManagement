package com.dotinschool.controller;

import com.dotinschool.model.bl.LoanTypeService;
import com.dotinschool.model.to.GrantCondition;
import com.dotinschool.model.to.LoanType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Maral ito on 4/23/2015.
 */
public class SubmitLoanTypeServlet extends HttpServlet {

    private static Logger logger = LogManager.getLogger(SubmitLoanTypeServlet.class);

    private LoanTypeService loanTypeService;
//    private GrantConditionService grantConditionService;

    public SubmitLoanTypeServlet(){
        loanTypeService = new LoanTypeService();
//        grantConditionService = new GrantConditionService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        logger.info("SubmitLoanType Servlet Called!");
        try {
            Integer.parseInt(request.getParameter("row_count").trim());
        }catch (NumberFormatException e){
            forwardToResultPage("وارد کردن حداقل یک شرط اعطا اجباری است", request, response, true, "One grant condition is required");
        }
        int rowCount = Integer.parseInt(request.getParameter("row_count").trim());
        String[] conditionNames = request.getParameterValues("condition_name");
        String[] minimumDays = request.getParameterValues("minimum_days");
        String[] maximumDays = request.getParameterValues("maximum_days");
        String[] minimumAmount = request.getParameterValues("minimum_amount");
        String[] maximumAmount = request.getParameterValues("maximum_amount");
        Set<GrantCondition> grantConditions = new HashSet<GrantCondition>();
        List<GrantCondition> grantConditionsList= new ArrayList<GrantCondition>();
        while (rowCount != 0){
            GrantCondition grantCondition = new GrantCondition();
            grantCondition.setName(conditionNames[rowCount - 1]);
            try {
                grantCondition.setMinimumDays(Integer.valueOf(minimumDays[rowCount - 1]));
                grantCondition.setMaximumDays(Integer.valueOf(maximumDays[rowCount - 1]));
                grantCondition.setMinimumAmount(Double.valueOf(minimumAmount[rowCount - 1]));
                grantCondition.setMaximumAmount(Double.valueOf(maximumAmount[rowCount - 1]));
            }catch (NumberFormatException e){
                forwardToResultPage("وارد کردن حداقل و حداکثر مبلغ و مدت قرارداد اجباری است. مبلغ و مدت حتما باید عدد باشد", request, response, true, "Amount and duration of contract are necessary. they must be number.");
            }
//            try {
//                grantConditionService.saveGrantCondition(grantCondition);
//            }catch(ConstraintViolationException e){
//                forwardToResultPage("وارد کردن نام شرط اعطا اجباری است", request, response, true);
//            }
            grantConditions.add(grantCondition);
            grantConditionsList.add(grantCondition);
            rowCount--;
        }
        String loanTypeName = request.getParameter("loan_type_name").trim();
        String interestRate = request.getParameter("interest_rate").trim();
        LoanType loanType = new LoanType();
        loanType.setName(loanTypeName);
        try {
            loanType.setInterestRate(Double.valueOf(interestRate));
        }catch (NumberFormatException e){
            forwardToResultPage("وارد کردن نرخ سود اجباری است. نرخ سود حتما باید عدد باشد", request, response, true, "Interest rate is necessary and must be number");
        }
        loanType.setConditions(grantConditions);
        try {
            loanTypeService.saveLoanType(loanType, grantConditionsList);
        }catch (ConstraintViolationException e){
            forwardToResultPage("وارد کردن نام نوع تسهیلات و نام شرط اعطا اجباری است", request, response, true, "Loan type name and condition name are necessary");
        }
        forwardToResultPage("نوع تسهیلات و شرایط اعطا با موفقیت ثبت شد", request, response, false, "Loan type saved!");

    }

    private void forwardToResultPage(String message, HttpServletRequest request, HttpServletResponse response, boolean isError, String logMessage) throws ServletException, IOException {
        request.setAttribute("message", message);
        if(isError){
            request.setAttribute("statusClass", "error");
            logger.error(message);
        }
        else{
            request.setAttribute("statusClass", "success");
            logger.info(message);
        }
        response.setCharacterEncoding("UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
    }
}

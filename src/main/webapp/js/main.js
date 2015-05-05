/**
 * Created by Dotin school 5 on 4/20/2015.
 */
function validateLoanType(){
    var interestRate = loan_type_form.interest_rate.value;
    var pattern = /[^0-9]^./;
    var result = pattern.test(interestRate);
  if(loan_type_form.loan_type_name.value == ""){
      document.getElementById("error_id").innerHTML = "<p dir='rtl' align='center'>وارد کردن نام نوع تسهیلات اجباری است</p>"
  }
  else if(interestRate == ""){
      document.getElementById("error_id").innerHTML = "<p dir='rtl' align='center'>وارد کردن نرخ سود اجباری است</p>"
  }
  else if(result){
      document.getElementById("error_id").innerHTML = "<p dir='rtl' align='center'>نرخ سود باید عدد باشد</p>"
  }
  else{
      document.getElementById("error_id").innerHTML = "<p dir='rtl' align='center'></p>";
      loan_type_form.submit();
  }
}

function addCondition(){
    var minimumDuration = document.getElementById("minimum_days_id").value;
    var maximumDuration = document.getElementById("maximum_days_id").value;
    var minimumAmount = document.getElementById("minimum_amount_id").value;
    var maximumAmount = document.getElementById("maximum_amount_id").value;
    var pattern = /[^0-9]/;
    var minimumDurationIsNotNumerical = pattern.test(minimumDuration);
    var maximumDurationIsNotNumerical = pattern.test(maximumDuration);
    var minimumAmountIsNotNumerical = pattern.test(minimumAmount);
    var maximumAmountIsNotNumerical = pattern.test(maximumAmount);
    if(document.getElementById("condition_name_id").value == ""){
        document.getElementById("error_id").innerHTML = "<p dir='rtl' align='center'>وارد کردن نام شرط اعطا اجباری است</p>"
    }
    else if(minimumDuration == ""){
        document.getElementById("error_id").innerHTML = "<p dir='rtl' align='center'>وارد کردن حداقل مدت قرارداد اجباری است</p>";
    }
    else if(maximumDuration == ""){
        document.getElementById("error_id").innerHTML = "<p dir='rtl' align='center'>وارد کردن حداکثر مدت قرارداد اجباری است</p>";
    }
    else if(minimumAmount == ""){
        document.getElementById("error_id").innerHTML = "<p dir='rtl' align='center'>وارد کردن حداقل مبلغ قرارداد اجباری است</p>";
    }
    else if(maximumAmount == ""){
        document.getElementById("error_id").innerHTML = "<p dir='rtl' align='center'>وارد کردن حداکثر مبلغ قرارداد اجباری است</p>";
    }
    else if(minimumDurationIsNotNumerical){
        document.getElementById("error_id").innerHTML = "<p dir='rtl' align='center'>حداقل مدت قرارداد باید عدد باشد</p>";
    }
    else if(maximumDurationIsNotNumerical){
        document.getElementById("error_id").innerHTML = "<p dir='rtl' align='center'>حداکثر مدت قرارداد باید عدد باشد</p>";
    }
    else if(minimumAmountIsNotNumerical){
        document.getElementById("error_id").innerHTML = "<p dir='rtl' align='center'>حداقل مبلغ قرارداد باید عدد باشد</p>";
    }
    else if(maximumAmountIsNotNumerical){
        document.getElementById("error_id").innerHTML = "<p dir='rtl' align='center'>حداکثر مبلغ قرارداد باید عدد باشد</p>";
    }
    else{
        document.getElementById("error_id").innerHTML = "<p dir='rtl' align='center'></p>";
        var table= document.getElementById("conditionsTableId");
        var row = table.insertRow(-1);
        var maxAmountCell = row.insertCell(0);
        var minAmountCell = row.insertCell(1);
        var maxDaysCell = row.insertCell(2);
        var minDaysCell = row.insertCell(3);
        var nameCell = row.insertCell(4);
        nameCell.style.textAlign = "center";
        minAmountCell.style.textAlign = "center";
        maxAmountCell.style.textAlign = "center";
        minDaysCell.style.textAlign = "center";
        maxDaysCell.style.textAlign = "center";
        nameCell.innerHTML = "<input class=\"input-table\" name=\"condition_name\" type=\"text\" value=\"" + document.getElementById("condition_name_id").value + "\" readonly/>";
        minDaysCell.innerHTML ="<input class=\"input-table\" name=\"minimum_days\" type=\"text\" value=\""+ document.getElementById("minimum_days_id").value+"\" readonly/>";
        maxDaysCell.innerHTML = "<input class=\"input-table\" name=\"maximum_days\" type=\"text\" value=\"" + document.getElementById("maximum_days_id").value + "\" readonly/>";
        minAmountCell.innerHTML = "<input class=\"input-table\" name=\"minimum_amount\" type=\"text\" value=\"" + document.getElementById("minimum_amount_id").value + "\" readonly/>";
        maxAmountCell.innerHTML = "<input class=\"input-table\" name=\"maximum_amount\" type=\"text\" value=\"" + document.getElementById("maximum_amount_id").value + "\" readonly/>";
        document.getElementById("row_count_id").value = table.rows.length - 1;
    }
}

function checkRowNum(){
    var table= document.getElementById("conditionsTableId");
    if(table.rows.length - 1 == 0){
        document.getElementById("error_id_2").innerHTML = "<p dir='rtl' align='center'>وارد کردن حداقل یک شرط اعطا اجباری است</p>";
    }
    else{
        conditions_form.submit();
    }
}




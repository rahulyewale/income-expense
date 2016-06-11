$(document).ready(function () {
	  $("#incomeDate").datepicker({
	        changeMonth: true,
	        changeYear: true,
	        showOn: 'button',
	        buttonImage: 'resources/img/calendar.gif',
	        buttonImageOnly: true,
	        buttonText: 'Select Date',
	        dateFormat: 'dd-M-yy',
	        showAnim: 'slideDown',
	        yearRange: "-100:+100",
	        duration: 'fast',
	    });
});

$("body").on('click', '#confirmAddIncome', function (e) {
	
	if($("#incomeDate").val()==='')
	{
		alert("Please enter income date");
		return;
	}
	
	$("#addIncomeModal").modal('hide');
	
	$("#incomeExpenseSummaryFormSubmit").click();
	
	 });

function resetIncomeModalValues()
{
	$("#incomeDate").val("");
	$("#incomeDescription").val("");

}



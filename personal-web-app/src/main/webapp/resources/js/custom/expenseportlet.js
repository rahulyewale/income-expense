$(document).ready(function() {
	
  
    $("#expenseDateDiv").datepicker({
        changeMonth: true,
        changeYear: true,
        showOn: 'button',
        buttonImage: 'resources/img/calendar.gif',
        buttonImageOnly: true,
        buttonText: 'Select Date',
        dateFormat: 'dd-M-yy',
        showAnim: 'slideDown',
        yearRange: "-100:+0",
        duration: 'fast',
    });
    
    $("#expenseDateDiv").datepicker('setDate', new Date());
    
    $("#cancel_add_expense").click(function() {
		createAndSubmitDynamicForm("summary", "", "POST", false);
	});
    
    $("body").on('click', '#btn_expense_submit_request', function (event) {
    	event.preventDefault();
    	$('#loadingImg').show();
    	
    	$.ajax({
    		
    		type : "POST",
    		url : appprotocol+"//"+apphost+"/"+apppathName+"/createExpense",
    		data :   $('#expenseForm').serialize(),
    		async:false,
    		success : function(response) {
    			$('#loadingImg').hide();
    			createAndSubmitDynamicForm("summary", "", "POST", false);
    			
    		},
    		error : function(e) {
    			alert('Error: ' + e);
    			console.log('Error: ' + e);
    		}
    	});
    	
	});
    
    $('#link_addincome').removeClass('active');
    $('#link_addexpense').addClass('active');
    $('#link_incomeexpensesummary').removeClass('active');
    
}); 

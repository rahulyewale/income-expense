$(document).ready(function() {
	
  
    $("#incomeDateDiv").datepicker({
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
    
    $("#incomeDateDiv").datepicker('setDate', new Date());
    
    $("#cancel_add_income").click(function() {
		createAndSubmitDynamicForm("summary", "", "POST", false);
	});
    
    //$("#btn_income_submit_request").click(function() {
    	$("body").on('click', '#btn_income_submit_request', function (event) {
    	
    	$('#loadingImg').show();
    	
    	$.ajax({
    		
    		type : "POST",
    		url : appprotocol+"//"+apphost+"/"+apppathName+"/createIncome",
    		data :   $('#incomeForm').serialize(),
    		async:false,
    		success : function(response) {
    			event.preventDefault();
    			$('#loadingImg').hide();
    			createAndSubmitDynamicForm("summary", "", "POST", false);
    			
    		},
    		error : function(e) {
    			alert('Error: ' + e);
    			console.log('Error: ' + e);
    		}
    	});
    	
	});
	

$('#link_addincome').addClass('active');
$('#link_addexpense').removeClass('active');
$('#link_incomeexpensesummary').removeClass('active');
	
}); 

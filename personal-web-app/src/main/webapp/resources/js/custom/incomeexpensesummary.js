$(document).ready(function() {
	$("#tabs").tabs( {
        "activate": function(event, ui) {
            $( $.fn.dataTable.tables( true ) ).DataTable().columns.adjust();
        }
    } );
     
    $('table.display').dataTable( {
        "scrollY": "200px",
        "scrollCollapse": true,
        "paging": false,
        "jQueryUI": true
    } );
    
    $("#fromDate").datepicker({
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
    
    $("#toDate").datepicker({
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
 
    
    $('#link_addincome').removeClass('active');
    $('#link_addexpense').removeClass('active');
    $('#link_incomeexpensesummary').addClass('active');
   
   /* $(window).load(function () {
        $(".loader").fadeOut("slow");
    });*/
}); 


$("body").on('click', '#addIncome', function (e) {
	 resetIncomeModalValues();
	$("#addIncomeModal").modal('show');
	 });

function generateReport() {
	 
	alert("calleed");
	$.ajax({
		type : "POST",
		url : "http" + "//" + "localhost" + "/" + "personal-web-app" + "/logistics/generateinvoice",
		data : '',
		async:false,
		success : function(response) {
		},
		error : function(jqXHR, textStatus, errorThrown) {
			 
		}
	});
	
}

function loadCSV() {

	alert("calleed");
	$.ajax({
		type : "POST",
		url : "generateinvoice",
		data : '',
		async : false,
		success : function(response) {
		},
		error : function(jqXHR, textStatus, errorThrown) {

		}
	});

}




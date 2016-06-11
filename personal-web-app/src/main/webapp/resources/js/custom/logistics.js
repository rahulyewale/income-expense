function loadCSV() {
alert("invoked");
	$.ajax({
		type : "POST",
		url : "loadcsv",
		data : $('#logisticsForm').serialize(),
		async : false,
		success : function(response) {
		},
		error : function(jqXHR, textStatus, errorThrown) {

		}
	});

}
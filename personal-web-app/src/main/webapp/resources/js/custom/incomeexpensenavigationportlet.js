$(document).ready(function() {
	
	$('#link_addincome').click(function(e) {

        $('#link_addincome').addClass('active');
        $('#link_addexpense').removeClass('active');

    });
	
	$('#link_addexpense').click(function(e) {

        $('#link_addincome').removeClass('active');
        $('#link_addexpense').addClass('active');

    });
    
});
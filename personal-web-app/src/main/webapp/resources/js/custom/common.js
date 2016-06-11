
var appprotocol = window.location.protocol;
	var apphost = window.location.host;
	var pathArray = window.location.pathname.split( '/' );
	var apppathName = pathArray[1];	

function createAndSubmitDynamicForm(path, params, method, isOpenRequestInNewTab) {
    method = method || "POST"; 
    var form = document.createElement("form");
    form.setAttribute("method", method);
    form.setAttribute("action", path);
    if(isOpenRequestInNewTab != "" && isOpenRequestInNewTab){
    	form.setAttribute("target", "_blank");
    }
    for(var key in params) {
        if(params.hasOwnProperty(key)) {
			    for(var prop in params[key]){
                 if(params[key].hasOwnProperty(prop)){
					var hiddenField = document.createElement("input");
					hiddenField.setAttribute("type", "hidden");
					hiddenField.setAttribute("name", prop);
					hiddenField.setAttribute("id", prop);
					hiddenField.setAttribute("value", params[key][prop]);
					form.appendChild(hiddenField);         
				}
			}
			
		}
    }
    document.body.appendChild(form);
    form.submit();
}
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Home Page</title>
<script src="resources/js/jquery-1.9.1.js"></script>
<script src="resources/js/jquery.form.js"></script>
<script src="resources/js/custom/file-upload.js"></script>
<script>
/* $(document).ready(function() {
    //add more file components if Add is clicked
    $('#addFile').click(function() {
        var fileIndex = $('#fileTable tr').children().length - 1;
        $('#fileTable').append(
                '<tr><td>'+
                '   <input type="file" name="files['+ fileIndex +']" />'+
                '</td></tr>');
    });
     
}); */
</script>
<link type="text/css" href="resources/css/bootstrap.css" rel="stylesheet"/>
<link type="text/css" href="resources/css/common.css" rel="stylesheet"/>
<link type="text/css" href="resources/css/jquery.dataTables.css" rel="stylesheet"/>
<link type="text/css" href="resources/css/ColVis.css" rel="stylesheet"/>

</head>
<body>
<div id="sgHeader" class="header">
  <div class="container"> <a class="brand" href="#">Home Application</a>
  </div>
</div>

	<!-- div id="tab_navigate_Id" class="nav-wrapper">
		<div class="container">
			<div class="navbar">
				<div class="navbar-inner">
					<ul role="navigation" aria-label="Main" class="nav">
						<li value="aaa" id="link_dashboardId" class="active"><a
							href="/Personal-Web/dashboardTab">Dashboard</a></li>
						<li id="link_requestId"><a href="#" id="requestLinkId">Requests</a></li>
						<li id="link_manageId" class="dropdown"><a href="#"
							aria-haspopup="true" data-toggle="dropdown"
							class="dropdown-toggle">Manage <span class="caret"></span><span
								class="text-hidden">drop down </span></a>
						<ul aria-expanded="false" class="dropdown-menu">
								<li id="link_positionId"><a href="#" id="positionLinkId">Positions</a></li>
								<li id="link_workgroupId"><a href="#" id="workGrpLinkId">Workgroups</a></li>
								<li id="link_requestlistId"><a id="requestListLinkId"
									href="#">Request lists</a></li>
							</ul></li>
						<li id="link_batchId"><a href="#" id="migrationId">Batch</a></li>
						<li id="link_manageSmartcardId"><a href="#"
							id="manageSmartcardId">Manage Smartcard</a></li>
					</ul>
					<script src="js/portlets-js/common/mastSearch.js"
						type="text/javascript"></script>
					<div aria-label="site" role="search" class="form-search pull-right">
						<form class="adv-search" autocomplete="off">
							<fieldset>
								<legend class="text-hidden">Search:</legend>
								<label class="text-hidden" for="headerSearchInput">Search
									terms</label><input type="text" aria-describedby="mastheadSearchHelp"
									maxlength="80" placeholder="Name or NI Number or UUID"
									id="headerSearchInput" class="span4"><span
									class="text-hidden" id="mastheadSearchHelp">Given name,
									family name, NINo or UUID</span><label class="text-hidden"
									for="headerSearchSelect">Search type</label><select
									id="headerSearchSelect" class="span2"><option
										value="USER">Users</option>
									<option value="ORGANISATION">Organisations</option></select>
								<button class="btn btn-search" disabled="disabled"
									id="btn_headerSearchSubmit" type="button">Search</button>
							</fieldset>
						</form>
						<a id="advanceSearchLink" href="#"><span>Advanced
								search</span></a>
					</div>
					<form method="get" name="performMasrSearchFRM"
						action="loadSearchPage" autocomplete="off">
						<input type="hidden" value="CAREID" id="source"
							name="searchTypeDetails.source"><input type="hidden"
							id="type" name="searchTypeDetails.type"><input
							type="hidden" id="query" name="query"><input
							type="hidden" value="true" id="performSearch"
							name="performSearch">
					</form>
					<script
						src="js/portlets-js/change-user-role/changeUserRolePortlet.js"
						type="text/javascript"></script>
					<div id="changeUserRole" role="dialog" class="modal modal-big hide"
						data-backdrop="static" tabindex="-1">
						<div class="modal-header">
							<button onclick="closeRole()" aria-hidden="true"
								data-dismiss="modal" class="close" type="button"
								id="closeRoleButtonId">&nbsp;</button>
							<h3>Change Your Role</h3>
						</div>
						<div class="modal-body ">
							<div id="sel_mhsPartyKey">
								<form class="form-horizontal" autocomplete="off">
									<table id="table_associatedRoles" class="display dataTable">
										<thead>
											<tr>
												<th scope="col">&nbsp;</th>
												<th class="th-role-name" scope="col">Role</th>
												<th class="th-org-code" scope="col">Org code</th>
												<th class="th-org-name" scope="col">Organisation name</th>
											</tr>
										</thead>
										<tbody></tbody>
									</table>
								</form>
							</div>
						</div>
						<div class="modal-footer">
							<div class="row">
								<div class="span3 text-left">
									<button onclick="closeRole()" aria-hidden="true"
										data-dismiss="modal" class="btn" id="btn_cancelChangeRole">Cancel</button>
								</div>
								<div class="span3 pull-right">
									<button onclick="confirmRole()" aria-hidden="true" disabled=""
										id="confirm_changeRole" class="btn btn-primary">Confirm</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div-->
	
	<div class="data-table-wrap">
          <div role="grid" class="dataTables_wrapper" id="table_manage_request_lists_wrapper"><div class="top"><div class="dataTables_filter" id="table_manage_request_lists_filter"><label>Filter   <input type="text" aria-controls="table_manage_request_lists"></label></div><div class="ColVis TableTools"><button class="ColVis_Button TableTools_Button ColVis_MasterButton"><span></span></button></div><div id="table_manage_request_lists_update_time" class="table-update-time">This list was last updated at <span>10:48</span><a class="ic-btn-refresh" href="#">Refresh</a></div><table id="table_manage_request_lists" class="display dataTable" aria-describedby="table_manage_request_lists_info">
            <thead>
              <tr role="row"><th class="sorting_desc" role="columnheader" tabindex="0" aria-controls="table_manage_request_lists" rowspan="1" colspan="1" aria-sort="descending" aria-label="Request list: activate to sort column ascending"><span>Request list</span></th><th class="right th-pending-approval sorting" role="columnheader" tabindex="0" aria-controls="table_manage_request_lists" rowspan="1" colspan="1" aria-label="Pending approval: activate to sort column ascending"><span>Pending approval</span></th><th class="right th-pending-grant sorting" role="columnheader" tabindex="0" aria-controls="table_manage_request_lists" rowspan="1" colspan="1" aria-label="Pending grant: activate to sort column ascending"><span>Pending grant</span></th><th class="right th-rejected sorting" role="columnheader" tabindex="0" aria-controls="table_manage_request_lists" rowspan="1" colspan="1" aria-label="Rejected: activate to sort column ascending"><span>Rejected</span></th><th class="right th-completed sorting" role="columnheader" tabindex="0" aria-controls="table_manage_request_lists" rowspan="1" colspan="1" aria-label="Completed: activate to sort column ascending"><span>Completed</span></th><th class="right th-total sorting" role="columnheader" tabindex="0" aria-controls="table_manage_request_lists" rowspan="1" colspan="1" aria-label="Total: activate to sort column ascending"><span>Total</span></th><th class="buttons_cell sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label=""></th></tr>
            </thead>
            
          <tbody role="alert" aria-live="polite" aria-relevant="all"><tr class="odd">
                <td class="  sorting_1"><a href="#">U Request List Name</a></td>
                <td class="right ">0</td>
                <td class="right ">0</td>
                <td class="right ">5</td>
                <td class="right ">16</td>
                <td class="right ">25</td>
                <td class="buttons_cell "><a title="Edit" class="ic-btn  ic-btn-edit mR5" href="#">Edit</a><a title="Delete" class="ic-btn  ic-btn-delete" href="#">Delete</a></td>
              </tr><tr class="even">
                <td class="  sorting_1"><a href="#">U Request List Name</a></td>
                <td class="right ">10</td>
                <td class="right ">5</td>
                <td class="right ">10</td>
                <td class="right ">10</td>
                <td class="right ">50</td>
                <td class="buttons_cell "><a title="Edit" class="ic-btn  ic-btn-edit mR5" href="#">Edit</a><a title="Delete" class="ic-btn  ic-btn-delete" href="#">Delete</a></td>
              </tr><tr class="odd">
                <td class="  sorting_1"><a href="#">U Request List Name</a></td>
                <td class="right ">1</td>
                <td class="right ">5</td>
                <td class="right ">3</td>
                <td class="right ">5</td>
                <td class="right ">18</td>
                <td class="buttons_cell "><a title="Edit" class="ic-btn  ic-btn-edit mR5" href="#">Edit</a><a title="Delete" class="ic-btn  ic-btn-delete" href="#">Delete</a></td>
              </tr><tr class="even">
                <td class="  sorting_1"><a href="#">U Request List Name</a></td>
                <td class="right ">10</td>
                <td class="right ">15</td>
                <td class="right ">20</td>
                <td class="right ">10</td>
                <td class="right ">75</td>
                <td class="buttons_cell "><a title="Edit" class="ic-btn  ic-btn-edit mR5" href="#">Edit</a><a title="Delete" class="ic-btn  ic-btn-delete" href="#">Delete</a></td>
              </tr><tr class="odd">
                <td class="  sorting_1"><a href="#">U Request List Name</a></td>
                <td class="right ">10</td>
                <td class="right ">5</td>
                <td class="right ">10</td>
                <td class="right ">10</td>
                <td class="right ">50</td>
                <td class="buttons_cell "><a title="Edit" class="ic-btn  ic-btn-edit mR5" href="#">Edit</a><a title="Delete" class="ic-btn  ic-btn-delete" href="#">Delete</a></td>
              </tr><tr class="even">
                <td class="  sorting_1"><a href="#">U Request List Name</a></td>
                <td class="right ">1</td>
                <td class="right ">5</td>
                <td class="right ">3</td>
                <td class="right ">5</td>
                <td class="right ">18</td>
                <td class="buttons_cell "><a title="Edit" class="ic-btn  ic-btn-edit mR5" href="#">Edit</a><a title="Delete" class="ic-btn  ic-btn-delete" href="#">Delete</a></td>
              </tr><tr class="odd">
                <td class="  sorting_1"><a href="#">U Request List Name</a></td>
                <td class="right ">0</td>
                <td class="right ">0</td>
                <td class="right ">5</td>
                <td class="right ">16</td>
                <td class="right ">25</td>
                <td class="buttons_cell "><a title="Edit" class="ic-btn  ic-btn-edit mR5" href="#">Edit</a><a title="Delete" class="ic-btn  ic-btn-delete" href="#">Delete</a></td>
              </tr><tr class="even">
                <td class="  sorting_1"><a href="#">U Request List Name</a></td>
                <td class="right ">10</td>
                <td class="right ">5</td>
                <td class="right ">10</td>
                <td class="right ">10</td>
                <td class="right ">50</td>
                <td class="buttons_cell "><a title="Edit" class="ic-btn  ic-btn-edit mR5" href="#">Edit</a><a title="Delete" class="ic-btn  ic-btn-delete" href="#">Delete</a></td>
              </tr><tr class="odd">
                <td class="  sorting_1"><a href="#">U Request List Name</a></td>
                <td class="right ">1</td>
                <td class="right ">5</td>
                <td class="right ">3</td>
                <td class="right ">5</td>
                <td class="right ">18</td>
                <td class="buttons_cell "><a title="Edit" class="ic-btn  ic-btn-edit mR5" href="#">Edit</a><a title="Delete" class="ic-btn  ic-btn-delete" href="#">Delete</a></td>
              </tr><tr class="even">
                <td class="  sorting_1"><a href="#">U Request List Name</a></td>
                <td class="right ">0</td>
                <td class="right ">0</td>
                <td class="right ">5</td>
                <td class="right ">16</td>
                <td class="right ">25</td>
                <td class="buttons_cell "><a title="Edit" class="ic-btn  ic-btn-edit mR5" href="#">Edit</a><a title="Delete" class="ic-btn  ic-btn-delete" href="#">Delete</a></td>
              </tr></tbody></table><div class="bottom"><div id="table_manage_request_lists_length" class="dataTables_length"><label><select name="table_manage_request_lists_length" size="1" aria-controls="table_manage_request_lists"><option value="10" selected="selected">10</option><option value="25">25</option><option value="50">50</option></select></label></div><div class="dataTables_info" id="table_manage_request_lists_info">Showing:1 to 10 of 35 </div><div class="dataTables_paginate paging_full_numbers" id="table_manage_request_lists_paginate"><a class="first paginate_button paginate_button_disabled" tabindex="0" id="table_manage_request_lists_first">First</a><a class="previous paginate_button paginate_button_disabled" tabindex="0" id="table_manage_request_lists_previous">Previous</a><span><a class="paginate_active" tabindex="0">1</a><a class="paginate_button" tabindex="0">2</a><a class="paginate_button" tabindex="0">3</a><a class="paginate_button" tabindex="0">4</a></span><a class="next paginate_button" tabindex="0" id="table_manage_request_lists_next">Next</a><a class="last paginate_button" tabindex="0" id="table_manage_request_lists_last">Last</a></div></div><div class="clear"></div></div></div>
        </div>

	<form id="fileUploadForm" class="form-horizontal" method="post" action="save" enctype="multipart/form-data">
 	<fieldset>
            <div class="control-group">
              <label class="control-label" for="fileName"><span class="text-required">*</span>File name:</label>
              <div class="controls">
                <input type="text" name="fileName" id="fileName" size="35" maxlength="35">
              </div>
            </div> 
            <div class="control-group">
              <label class="control-label" for="file">Select File:</label>
              <div class="controls">
                <input type="file" name="file" id="file" >
              </div>
            </div>
            <div class="control-group">
              <div class="controls">
                <input type="submit" value="Submit" class="btn btn-primary" />
              </div>
            </div>
            
    
   </fieldset>
	</form>
	
<!-- <button value="Submit" onclick="uploadFormData()" class="btn btn-success"  >Upload</button> -->
</body>
</html>
$("#btnConfirm").on("click", function() {
// var myVar = $("#taskTable").find('.addtask');
// var selected = {};
// myVar.each(function() {
// if($(this)[0].checked == true)
// selected[$(this).attr("taskid")] = $(this)[0].checked;
// });
// console.log(selected);
// var classid = $("#class")[0].value;
// var student = ($("#student")[0].value);
	console.log(document.location.hostname);
	fire_ajax_submit();
	
})

function fire_ajax_submit() {

    var data = {}
    var myVar = $("#taskTable").find('.addtask');
	var selected = {};
	myVar.each(function() {
		if($(this)[0].checked == true)
			selected[$(this).attr("taskid")] = $(this)[0].checked;
	});
	var classid = $("#class")[0].value;
	var student = ($("#student")[0].value);
	
    data["selected"] =JSON.stringify(selected);
    data["class"] = classid;
    data["student"] = student;
    
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    $("#btnConfirm").prop("disabled", true);

    
    console.log(data);
    
    var request = $.ajax({
        type: 'POST',
        dataType: 'json',
        url: "../Rest/AssignTask",
        data: data,
        beforeSend: function(xhr) {
            // here it is
            xhr.setRequestHeader(header, token);
        },
        success: function(data) {
        	console.log("Request success: " + JSON.stringify(data));
        },
    	error: function(jqXHR, textStatus) {
    		console.log("Request failed: " + JSON.stringify(jqXHR));
    		window.location.replace("http://"+document.location.hostname+":8080"+jqXHR.responseText);
    	}
    })

};

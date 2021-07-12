//******************************************************************************
//******************************************************************************
function getRequest(link, func){
	var http = new XMLHttpRequest();
	http.open('GET', link);
	http.onreadystatechange = function(){
		if(http.readyState == 4 && http.status == 200){
			func(http.responseText);
		}
	}
	http.send(null);
}

function postRequest(link, data, func){
	var http = new XMLHttpRequest();
	http.open('POST', link, true);
	http.onreadystatechange = function(){
		if(http.readyState == 4 && http.status == 200){
			func(http.responseText);
		}
	}
	http.send(data);
}
//******************************************************************************
//******************************************************************************
function stringLimitLength(str, limit){
	if(str.length <= limit) 
		return str;
	return str.substring(0, limit) + "..."; 
}

function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}

function getById(id){
	return document.getElementById(id);
}

function getByName(name){
	return document.getElementsByName(name);
}

function loadHistory(id){
	getRequest("?action=get-history-list-act&id=" + id, function(resp){
		getById("history-data").innerHTML = resp;
	});
}

function search(){
	location.href = "./?link=equipment&search=" + getById('search-text').value;
}
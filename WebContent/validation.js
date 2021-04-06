function checkItemForm()
  {
	console.log('In checkForm()');
    // check make
    let make = document.getElementById('make').value;
	let re = /^[A-Za-z\s\-]+$/;
	if (make == "") {
		alert("Error - please enter a make");
		return false;
	}
	
	else if (!re.test(make)) {
		alert("Error - make can only contain letters separated with spaces or hyphens");
		return false;
    }
	
	// check model
	let model = document.getElementById('model').value;
	re = /^[0-9A-Za-z\s\-]+$/;
	
	if (model == "") {
		alert("Error - please enter a model");
		return false;
	}
	
	if (!re.test(model)) {
		alert("Error - model can only contain letters and numbers separated with spaces or hyphens");
		return false;
    }
	
	
	//check year
	let year = document.getElementById('year').value;
	let currYear = new Date().getFullYear()
	if (year == "") {
		alert("Error - please enter a year");
		return false;
	}
	
	parsed = parseInt(year);
	console.log("year is " + year);
	
	if (isNaN(parsed)){
		
		alert("Error - year must be entered in digits");
		return false;
	}
	
	if (parsed < 1900 || parsed > (currYear + 10)){
		
		alert("Error - enter a realistic year");
		return false;
	}

    // validation was successful
    return true;
  }

function checkOwnerForm (){
	
	let name = document.getElementById('name').value;
	let re = /^[a-z ,.'-]+$/i
	
	if (name == "") {
		alert("Error - please enter a name");
		return false;
	}
	
	if (!re.test(name)) {
		alert("Error - invalid name entered");
		return false;
    }
	
	// validation was successful
    return true;
}

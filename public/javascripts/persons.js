function getPerson(personId) {
	ajaxCall(personId);
}

var ajaxCall = function(personId) {
	var ajaxCallBack = {
		success : onSuccess,
		error : onError
	}

	personsRouter.controllers.Application.get(personId).ajax(ajaxCallBack);
};

var onSuccess = function(data) {
	var personModal = $('#edit-person-modal');
	personModal.modal('show');
	console.log(data.name);
}

var onError = function(error) {
	alert(error);
}
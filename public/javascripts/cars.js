function getCar(carId) {
	ajaxCall(carId);
}

var ajaxCall = function(carId) {
	var ajaxCallBack = {
		success : onSuccess,
		error : onError
	}

	carsRouter.controllers.CarsController.get(carId).ajax(ajaxCallBack);
};

var onSuccess = function(data) {
	$('#delete-car-form').attr('action', 'cars/'+data.id+'/delete');
	$('#update-car-form').attr('action', 'cars/'+data.id);
	var carModal = $('#edit-car-modal');
	carModal.modal('show');
	$('#name-edit').val(data.name);
	$('#description-edit').val(data.description);
	$('#kilometers-edit').val(data.kilometers);
	$('#color-edit').val(data.color);

}

var onError = function(error) {
	alert(error);
}
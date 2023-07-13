//사진 크게 보기
$(document).on('click', '.popfile img', function(){
	$('#modal-image .modal-body').html($(this).clone());
	$('#modal-image .modal-body img').removeAttr('style');
	new bootstrap.Modal($('#modal-image')).show();
})

function animal_sido(){
	$.ajax({
		url: 'animal/sido'
	}).done(function(response){
		$('.animal-top').append(response);
	})
}


//유기동물목록 조회
function animal_list( pageNo ){
	$('.pharmacy-top').addClass('d-none');
	$('#data-list').empty();
	$('.pagination').closest('nav').remove(); //페이지목록이 이미 있으면 삭제
	
	$('.loading').show();
	
	if($('#sido').length==0) animal_sido(); //시도 조회
	
	page.curPage = pageNo;
	var animal = page; //요청하는 페이지번호, 페이지당 보여질 목록수
	animal.sido = $('#sido').length==0 ? '' : $('#sido').val();
	
//	console.log('page의 현재페이지번호', page.curPage);
//	console.log('요청하려는 현재페이지번호', pageNo);
//	console.log('animal 객체 정보', animal);
	
	$.ajax({
		url: 'animal/list',
		data: JSON.stringify(animal),
		type: 'post',
		contentType: 'application/json',
//		data: { pageNo: pageNo, rows: page.pageList },
		async: false,
	}).done(function( response ){
		$('#data-list').html( response )
	})
	
	setTimeout( function(){ $('.loading').hide() }, 500) ;
}
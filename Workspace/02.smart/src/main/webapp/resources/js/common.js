/** 
 * 공통 함수 선언
 */

//파일이 이미지파일인지 확인
function isImage(filename){
	// abc.png, abc.jpg, abc.txt, abc.hwp, abc.BMP, abc.JPG
	var ext = filename.substr(filename.lastIndexOf('.')+1).toLowerCase();
	var imgs = ["png", "jpg", "bmp", "gif", "jpeg", "webp"];
	return imgs.indexOf(ext)==-1 ? false : true;
}

$(function(){
	
	//프로필 이미지 선택처리
	$('input#file-single').change(function(){
//		console.log($(this))
//		console.log(this.files)
		
		var _preview = $('#file-attach .file-preview');
		var _delete = $('#file-attach .file-delete');
		
		var attached = this.files[0];
		console.log(attached)
		if(attached){
			//이미지파일인지 확인
			if(isImage(attached.name)){
				_delete.removeClass('d-none');//삭제버튼 보이게
				// 미리보기 태그가 있을 때만
				if(_preview.length > 0){
					_preview.html("<img>");
					
					var reader = new FileReader();
					reader.readAsDataURL(attached);
					reader.onload = function(e){
//						_preview.children("img").attr("src", e.target.result);
						_preview.children("img").attr("src", this.result);
					}
				}
			}else {
				//이전 선택했던 이미지파일처리
				_preview.empty();
				$(this).val('');		 //실제file 태그의 정보 초기화
				_delete.addClass('d-none');//삭제버튼 안 보이게
			}
		}
	})
	
	$('.date').change(function(){
		$(this).next('.date-delete').css('display', 'inline')
	})
	
	$('[name=phone]').keyup(function(){
	toPhone($(this));
	})
	
	var today = new Date();
	var range = today.getFullYear()-100 + ':' + today.getFullYear();
	$.datepicker.setDefaults({
		dateFormat: "yy-mm-dd",
		changeYear: true,
		changeMonth: true,
		yearRange: range,
		showMonthAfterYear: true,
		monthNamesShort: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
		dayNamesMin: ["일", "월", "화", "수", "목", "금", "토"],
		maxDate: today,
	})
	
	 $( ".date" ).datepicker();
	 $( ".date" ).attr('readonly', true);
})

function modalAlert(type, title, message){
	$('#modal-alert .modal-title').html(title);
	$('#modal-alert .modal-body').html(message);
	
	
	$('.modal-icon').removeClass('text-info text-warning text-danger text-primary fa-circle-question fa-circle-exclamation')
	// 아니오/확인으로 사용되는 버튼의 색상 초기화
	$('.modal-footer .btn-ok').removeClass('btn-info btn-warning btn-danger btn-primary btn-success');
	if(type=='danger') {//confirm에 해당
		//아니오, 예 버튼
		$('.modal-footer .btn-ok').addClass('btn-secondary').text('아니오')
		$('.modal-footer .btn-danger').removeClass('d-none')
		
		$('.modal-icon').addClass('fa-circle-question') //아이콘 물음표
		
	}else {
		$('.modal-footer .btn-ok').addClass('btn-'+type).text('확인')
		$('.modal-footer .btn-danger').addClass('d-none')
		
		$('.modal-icon').addClass('fa-circle-exclamation') //아이콘 물음표
	}
	$('.modal-icon').addClass('text-'+type);
}


function toPhone(tag){

	// 02-1234-5678(10자리) 010-1234-5678(11자리)
	var phone = tag.val().replace(/[^0-9]/g, '').replace(/[-]/g, ''); //숫자만 입력되게 처리 01012345678
	if(phone.length > 1) { //2자리 이상 입력하면 02, 062, 010
		// - 가 들어가야 할 위치 계산하기
		var start = phone.substr(0, 2)=="02" ? 2 : 3; // 첫번째 항목 : 02, 062
		middle = start + 4; // 두번째 항목 : 1234 - 무조건 4자리
		
		// - 만들어서 넣기
		if(phone.length > middle){
			phone = phone.substr(0, start) + "-" + phone.substr(start, 4) + "-" + phone.substr(middle, 4);
		}else if(phone.length > start){
			phone = phone.substr(0, start) + "-" + phone.substr(start, 4) + "-";
		}
		
	}
	// substr(시작, 길이), substring(시작, 끝위치)
	tag.val(phone);
}

//동적으로 만들어진 요소에 대해서는 document에 이벤트를 등록해야 한다.
$(document).on('click', '.date + .date-delete', function(){
	$(this).css('display', 'none'); // 삭제버튼 안보이게
	$(this).prev('.date').val('');// 날짜태그의 값을 초기화
})




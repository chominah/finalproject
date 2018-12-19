/**
 * 
 */
function goUrl(url) {
	console.log("param : "+url);
	location=url;	
	}
//수정, 삭제에 사용될 함수
//my.kosta188?cmd=Z&num=??
function goConfirmUrl(url, num) {
	if(confirm("go_detail?")){
		console.log("param : "+url);
		location=url+"num="	+num;
	}
	}

function goDeleteUrl(url, num){
	if(confirm("go_delete?")){
		console.log("num : "+num);
		location=url+"num=" +num;
	}
}
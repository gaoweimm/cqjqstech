var shop_id = '';
var detail_id = '';
var imgSrc='data:image/png;base64,';
var oper_no = '';
$(document).ready(function() {
	detail_id = GetQueryString('detail_id');
	shop_id = GetQueryString('shop_id');
	oper_no = $.session.get('oper_no');
	$('#userinfo_oper_no').text("欢迎  "+oper_no+" 登录");
	getShopDetailById(shop_id);
	getCommentList();
	comment();
	$('#comment_oper_no').text(oper_no);
});

function comment(){
	$('#not_bat').bind('click',function(e){
		$('#not_bat').attr("class", "custom_checked");
		$('#comments').attr("class", "custom_check");
		$('#improve').attr("class", "custom_check");
		$('#lose').attr("class", "custom_check");
	});
	$('#comments').bind('click',function(e){
		$('#not_bat').attr("class", "custom_check");
		$('#comments').attr("class", "custom_checked");
		$('#improve').attr("class", "custom_check");
		$('#lose').attr("class", "custom_check");
	});
	$('#improve').bind('click',function(e){
		$('#not_bat').attr("class", "custom_check");
		$('#comments').attr("class", "custom_check");
		$('#improve').attr("class", "custom_checked");
		$('#lose').attr("class", "custom_check");
	});
	$('#lose').bind('click',function(e){
		$('#not_bat').attr("class", "custom_check");
		$('#comments').attr("class", "custom_check");
		$('#improve').attr("class", "custom_check");
		$('#lose').attr("class", "custom_checked");
	});
	
}
function getShopDetailById(shop_id) {

	var registClient = {
		onComplete : function(args) {
			$('#detail_name').text(args.shopDetail.detail_name);
			$('#detail_introduction').append(args.shopDetail.detail_introduction);
			$("#detail_pic1").attr('src',imgSrc + args.shopDetail.detail_pic1); 
			$('#detail_sale').text(args.shopDetail.detail_sale);
			$('#detail_traffic').text(args.shopDetail.detail_traffic);
			$('#detail_contact').text(args.shopDetail.detail_contact);
			$('#detail_pic2').attr('src',imgSrc + args.shopDetail.detail_pic2);
			$('#detail_pic3').attr('src',imgSrc + args.shopDetail.detail_pic3);
			$('#detail_pic4').attr('src',imgSrc + args.shopDetail.detail_pic4);
			$('#detail_pic5').attr('src',imgSrc + args.shopDetail.detail_pic5);
			
		},
		onError : function(error) {
			return;
		},
		onException : function(status, errorInfo, hint) {
			return;
		}
	};

	WebUtil.doPost(
			
			URLS.URL_API_HOST + 'rest/shop/findShopDetail', {
				shop_id:shop_id,
				detail_id:detail_id
			},
			false, registClient);
}

function getCommentList(){
	if(''==oper_no){
		window.location.href = "login.html";
		alert("请先登录！");
	}
	var score_box = '';
	var registClient = {
		onComplete : function(args) {
			$('#score_box').text('');
			for (var i = 0; i < args.commentList.length; i++) {
				nDate = new Date(args.commentList[i].create_date);
				score_box = score_box + '<div class="clear"></div>'+
                '<div class="score_row">'+
                    '<div class="score_user">'+
                        '<img src="../img/outing_7.jpg" class="head_img" />'+
                        '<div>'+args.commentList[i].user_id+'</div>'+
                    '</div>'+
                    '<div class="score_info">'+
                        '<div class="score_label">评分：</div>'+
                        '<div class="score_txt">'+

                        	'<div class="score_start"></div>'+
                        	'<div class="score_start"></div>'+
                        	'<div class="score_start"></div>'+
                        	'<div class="score_start"></div>'+
                        	'<div class="score_start"></div>'+
                            
                        '</div>'+                    
                       	'<div class="score_label">内容：</div>'+
                        '<div class="score_txt">'+args.commentList[i].comment_text+'</div>'+                        
                        '<div class="score_label"></div>'+
                        '<div class="score_txt">'+Format(nDate,"yyyy-MM-dd HH:mm")+'</div>'+
                        
                    '</div>'+
                    '<div class=" clear"></div>';
			}
			$('#score_box').append(score_box);
			
		},
		onError : function(error) {
			return;
		},
		onException : function(status, errorInfo, hint) {
			return;
		}
	};

	WebUtil.doPost(
			
			URLS.URL_API_HOST + 'rest/comment/findComment', {
				shop_id:shop_id,
				detail_id:detail_id
			},
			false, registClient);

}

function saveComment(){
	var comment_text = $('#comment_text').text();
	var registClient = {
		onComplete : function(args) {
			$('#comment_text').text('');
			getCommentList();
		},
		onError : function(error) {
			return;
		},
		onException : function(status, errorInfo, hint) {
			return;
		}
	};

	WebUtil.doPost(
			
			URLS.URL_API_HOST + 'rest/comment/saveCommentClient', {
				shop_id:shop_id,
				user_id:oper_no,
				comment_text:comment_text,
				comment_level:'很好'
			},
			false, registClient);
	
}


function Format(now,mask)
{
    var d = now;
    var zeroize = function (value, length)
    {
        if (!length) length = 2;
        value = String(value);
        for (var i = 0, zeros = ''; i < (length - value.length); i++)
        {
            zeros += '0';
        }
        return zeros + value;
    };
 
    return mask.replace(/"[^"]*"|'[^']*'|\b(?:d{1,4}|m{1,4}|yy(?:yy)?|([hHMstT])\1?|[lLZ])\b/g, function ($0)
    {
        switch ($0)
        {
            case 'd': return d.getDate();
            case 'dd': return zeroize(d.getDate());
            case 'ddd': return ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'][d.getDay()];
            case 'dddd': return ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'][d.getDay()];
            case 'M': return d.getMonth() + 1;
            case 'MM': return zeroize(d.getMonth() + 1);
            case 'MMM': return ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'][d.getMonth()];
            case 'MMMM': return ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'][d.getMonth()];
            case 'yy': return String(d.getFullYear()).substr(2);
            case 'yyyy': return d.getFullYear();
            case 'h': return d.getHours() % 12 || 12;
            case 'hh': return zeroize(d.getHours() % 12 || 12);
            case 'H': return d.getHours();
            case 'HH': return zeroize(d.getHours());
            case 'm': return d.getMinutes();
            case 'mm': return zeroize(d.getMinutes());
            case 's': return d.getSeconds();
            case 'ss': return zeroize(d.getSeconds());
            case 'l': return zeroize(d.getMilliseconds(), 3);
            case 'L': var m = d.getMilliseconds();
                if (m > 99) m = Math.round(m / 10);
                return zeroize(m);
            case 'tt': return d.getHours() < 12 ? 'am' : 'pm';
            case 'TT': return d.getHours() < 12 ? 'AM' : 'PM';
            case 'Z': return d.toUTCString().match(/[A-Z]+$/);
            // Return quoted strings with the surrounding quotes removed
            default: return $0.substr(1, $0.length - 2);
        }
    });
};

function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}
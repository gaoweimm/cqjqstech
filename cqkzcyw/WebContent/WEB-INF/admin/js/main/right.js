 var oper_type = '';
 var merchants = '';
 var oper_type_temp = ''
$(document).ready(function () {
  oper_type = $.session.get('oper_type');
  oper_type_temp = $.session.get('oper_type_temp');
  getUserinfo(oper_type);
  $.session.set('oper_type', oper_type_temp);
});
$.extend({
  getUrlVars: function () {
    var vars = [
    ],
    hash;
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for (var i = 0; i < hashes.length; i++)
    {
      hash = hashes[i].split('=');
      vars.push(hash[0]);
      vars[hash[0]] = hash[1];
    }
    return vars;
  },
  getUrlVar: function (name) {
    return $.getUrlVars() [name];
  }
});
function getUserinfo(oper_type) {
  var show_userinfo = '';
  var nDate = '';
  var registClient = {
    onComplete: function (args) {
      console.info(args.userinfo.length);
      console.info(args.userinfo.oper_name);
      for (var i = 0; i < args.userinfo.length; i++) {
    	  nDate = new Date(args.userinfo[i].create_date);
    	 if(oper_type != args.userinfo[i].oper_type){
    		 continue;
    	 }
        show_userinfo = show_userinfo + '<tr><td><input name=\'\' type=\'checkbox\' value=\'\' /></td>' +
        '<td>' + args.userinfo[i].oper_no + '</td>' +
        '<td>' + args.userinfo[i].oper_name + '</td>' +
        '<td>' + args.userinfo[i].oper_qq + '</td>' +
        '<td>' + args.userinfo[i].oper_phone + '</td>' +
        '<td>' + Format(nDate,"yyyy-MM-dd HH:mm") + '</td>' +
        '<td>' + args.userinfo[i].oper_flag + '</td><td>' +
        ' <a href=\'updateUserinfo.html?oper_id='+args.userinfo[i].oper_id+
        '&oper_name='+ args.userinfo[i].oper_name+
        '&oper_qq=' + args.userinfo[i].oper_qq +
        '&oper_phone=' + args.userinfo[i].oper_phone +
        '&oper_no='+ args.userinfo[i].oper_no +
        '&oper_pwd=' + args.userinfo[i].oper_pwd +
        '&oper_type=' + args.userinfo[i].oper_type +
        '&oper_flag=' + args.userinfo[i].oper_flag +
        '& class=\'tablelink\'>修改</a>  '+
        '  <a href='+ URLS.URL_API_HOST + 'rest/userinfo/deleteUserinfoById?oper_id='+args.userinfo[i].oper_id+' class=\'tablelink\'>删除</a>   ' +
        '</td></tr>';
        $('#tbody_show').html(show_userinfo);
      }
    },
    onError: function (error) {
      return;
    },
    onException: function (status, errorInfo, hint) {
      return;
    }
  };
  oper_type = $.session.get('oper_type');
  WebUtil.doGet(URLS.URL_API_HOST + 'rest/userinfo/getByOperType', {
	  oper_type:oper_type
  }, true, registClient);
};

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

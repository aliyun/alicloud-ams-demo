var sign = require('./sign.js');
var popEscape = require('./popEscape.js');

module.exports = {
    request : function(host,params,secret){
	var keys = Object.keys(params);
        var param = '';
	for (key in keys) {
    	    param = param + popEscape.popEscape(keys[key]) + "=" + popEscape.popEscape(params[keys[key]]) + "&";
	}
        request = host + "/?" + param + "Signature=" + popEscape.popEscape(sign.sign("GET",params,secret));
	return request;
    }
};

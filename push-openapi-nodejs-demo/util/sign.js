var cryptoLib =  require('crypto');
var popEscape = require('./popEscape.js');


module.exports = { 
sign : function(method, params, accessKeySecret) {
  var QueryString = '';
  var keys = Object.keys(params).sort();
  for (key in keys) {
    QueryString = QueryString + keys[key] + "=" + popEscape.popEscape(params[keys[key]]) + "&";
  }
  QueryString = QueryString.substring(0,QueryString.length-1)
  const stringToSign = method + "&%2F&" + popEscape.popEscape(QueryString);
  return hmac(accessKeySecret + '&', stringToSign, 'base64', 'sha1');
}
var hmac = function(key, string, digest, fn) {
  if (!digest) {
    digest = 'binary';
  }
  if (digest === 'buffer') {
    digest = undefined;
  }
  if (!fn) {
    fn = 'sha256';
  }
  if (typeof string === 'string') {
    string = new Buffer(string);
  }
  return cryptoLib.createHmac(fn, key).update(string).digest(digest);
}
};

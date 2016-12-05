var cryptoLib =  require('crypto');


module.exports = {

popEscape: function(clearString) {

  clearString = encodeURIComponent(clearString)
    .replace(/\!/gi, '%21')
    .replace(/\'/gi, '%27')
    .replace(/\(/gi, '%28')
    .replace(/\)/gi, '%29')
    .replace(/\*/gi, '%2A')
  return clearString;
}

};

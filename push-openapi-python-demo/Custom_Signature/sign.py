import hashlib
import hmac
import base64
from popEncode import *

def sign(method,params,secret):
    query_string = ''
    for k in sorted(params.keys()):
        query_string += '&' + pop_encode(k) + "=" + pop_encode(params[k])
    sign_to_string = method + "&%2F&" + pop_encode(query_string[1:])
    h = hmac.new(secret, sign_to_string , hashlib.sha1)
    signature = base64.encodestring(h.digest())
    return signature
        

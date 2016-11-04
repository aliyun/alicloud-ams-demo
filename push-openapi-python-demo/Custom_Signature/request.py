from sign import *
def request(host,params,secret):
    param_string = ''
    for k in sorted(params.keys()):
        param_string += urllib.quote(k) + "=" + urllib.quote(params[k]) + "&"
    request = host + "/?" + param_string + "Signature=" + sign("GET",params,secret+'&')
    return request

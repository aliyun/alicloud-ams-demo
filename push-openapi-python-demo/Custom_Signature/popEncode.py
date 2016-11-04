# -*- coding: utf-8 -*-

import time
import urllib
import sys

def pop_encode(encodeStr):
    encodeStr = str(encodeStr)
    if sys.stdin.encoding is None:
        res = urllib.quote(encodeStr.decode('cp936').encode('utf8'), '')
    else:
        res = urllib.quote(encodeStr.decode(sys.stdin.encoding).encode('utf8'), '')
    res = res.replace('+', '%20')
    res = res.replace('*', '%2A')
    res = res.replace('%7E', '~')
    return res

<?php
	include 'pop_encode.php';
	function sign($method,$params,$secret)
	{
		ksort($params);
		$canonicalizedQueryString = '';
		foreach($params as $key => $value)
            	{
                        $canonicalizedQueryString .= '&' . pop_encode($key). '=' . pop_encode($value);
            	}
		$stringToSign = $method . '&%2F&' . pop_encode(substr($canonicalizedQueryString, 1));
		return base64_encode(hash_hmac('sha1', $stringToSign, $secret, true));
	}
?>

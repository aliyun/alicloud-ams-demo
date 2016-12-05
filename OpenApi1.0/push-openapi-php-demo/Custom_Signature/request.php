<?php   
	include "sign.php";
	function request($host,$params,$secret)
	{
		$param_string = "";
		foreach($params as $key => $value)
		{
			$param_string .= urlencode($key) . "=" . urlencode($value) . "&"; 
		}
		return  $host . "/?" . $param_string . "Signature=" . sign("GET",$params,$secret . "&");
	}
?>

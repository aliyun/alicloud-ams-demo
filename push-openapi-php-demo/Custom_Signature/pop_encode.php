<?php
function pop_encode($str)
{
	    $res = urlencode($str);
            $res = preg_replace('/\+/', '%20', $res);
            $res = preg_replace('/\*/', '%2A', $res);
            $res = preg_replace('/%7E/', '~', $res);
            return $res;
}
?>

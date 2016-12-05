  <?php	
	include 'request.php';
        $params = array(
	"Format" => "XML",
	"RegionId" => "ch-hangzhou",
	"Version" => "2015-08-27",
	"SignatureMethod" => "HMAC-SHA1",
	"Timestamp" => gmdate('Y-m-d\TH:i:s\Z', time()),
	"SignatureVersion" => "1.0",
	"SignatureNonce" => uniqid(),
	"Action" => "ListTags",
	"AccessKeyId" => "<Your AccessKey>",
	"AppKey" => "<Your AppKey>"
	);
	$host = "http://cloudpush.aliyuncs.com";
	$request = request($host,$params,"<Your SecretKey>");
	$ch = curl_init();
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
	curl_setopt($ch, CURLOPT_URL,$request);
	$content = curl_exec($ch);
	echo $content;
      ?>

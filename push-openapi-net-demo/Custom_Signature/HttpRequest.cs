using System;
using System.Collections.Generic;

namespace AliCloudPush
{
    public class HttpRequest
    {
        public Dictionary<string, string> Headers { get; set; }
        public String Url { get; set; }
        public MethodType? Method { get; set; }
        public FormatType? ContentType { get; set; }
        public byte[] Content { get; set; }
        public String Encoding { get; set; }

        public HttpRequest() { }

        public HttpRequest(String strUrl)
        {
            Url = strUrl;
            Headers = new Dictionary<string, string>();
        }

        public HttpRequest(String strUrl, Dictionary<string, string> tmpHeaders)
        {
            Url = strUrl;
            if (null != tmpHeaders)
            {
                Headers = tmpHeaders;
            }
        }

        public void SetContent(byte[] content, String encoding, FormatType? format)
        {
            if (null == content)
            {
                Headers.Remove("Content-MD5");
                Headers.Remove("Content-Length");
                Headers.Remove("Content-Type");
                ContentType = null;
                Content = null;
                Encoding = null;
                return;
            }
            String contentLen = content.Length.ToString();
            String strMd5 = ParameterHelper.Md5Sum(content);
            FormatType? type = FormatType.RAW;
            if (null != format)
            {
                ContentType = format;
                type = format;
            }
            this.Headers.Add("Content-MD5", strMd5);
            this.Headers.Add("Content-Length", contentLen);
            this.Headers.Add("Content-Type", ParameterHelper.FormatTypeToString(type));

            this.Content = content;
            this.Encoding = encoding;
        }
    }

    public enum MethodType
    {
        GET,
        PUT,
        POST,
        DELETE,
        HEAD,
        OPTIONS
    }
    public enum FormatType
    {
        XML,
        JSON,
        RAW
    }
}


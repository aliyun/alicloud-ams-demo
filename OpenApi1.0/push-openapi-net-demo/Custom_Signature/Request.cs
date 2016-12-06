using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AliCloudPush
{
    class Request
    {
        public static string request(string host, SortedDictionary<string, object> parameters,string secret)
        {
            StringBuilder queryString = new StringBuilder();
            foreach (var p in parameters)
            {
                queryString
                .Append(PopEncode.Encode(p.Key)).Append("=")
                .Append(PopEncode.Encode(p.Value.ToString()))
                .Append("&");
            }
            string request = host + "/?" + queryString + "Signature=" + Sign.sign("GET",parameters,secret+"&");
            return request;
        }
    }
}

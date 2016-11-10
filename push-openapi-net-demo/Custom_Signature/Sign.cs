using System;
using System.Collections.Generic;
using System.Text;
using System.Security.Cryptography;

namespace AliCloudPush
{
    class Sign
    {
        private const String SEPARATOR = "&";
        public static string sign(string method, SortedDictionary<string, object> parameters,string secret)
        {
            StringBuilder canonicalizedQueryString = new StringBuilder();
            foreach (var p in parameters)
            {
                canonicalizedQueryString.Append("&")
                .Append(PopEncode.popEncode(p.Key)).Append("=")
                .Append(PopEncode.popEncode(p.Value.ToString()));
            }
            StringBuilder stringToSign = new StringBuilder();
            stringToSign.Append(method.ToString());
            stringToSign.Append(SEPARATOR);
            stringToSign.Append(PopEncode.popEncode("/"));
            stringToSign.Append(SEPARATOR);
            stringToSign.Append(PopEncode.popEncode(
                    canonicalizedQueryString.ToString().Substring(1)));

            var algorithm = KeyedHashAlgorithm.Create("HMACSHA1");
            algorithm.Key = Encoding.UTF8.GetBytes(secret.ToCharArray());
            return Convert.ToBase64String(algorithm.ComputeHash(Encoding.UTF8.GetBytes(stringToSign.ToString().ToCharArray())));
        }
    }
}

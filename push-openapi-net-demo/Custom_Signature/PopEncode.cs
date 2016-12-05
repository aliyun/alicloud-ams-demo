using System;
using System.Globalization;
using System.Text;
using System.Web;

namespace AliCloudPush
{
    class PopEncode
    {
        private const string ENCODING_UTF8 = "UTF-8";
        public static string popEncode(string value)
        {
            StringBuilder stringBuilder = new StringBuilder();
            string text = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_.~";
            byte[] bytes = Encoding.GetEncoding(ENCODING_UTF8).GetBytes(value);
            foreach (char c in bytes)
            {
                if (text.IndexOf(c) >= 0)
                {
                    stringBuilder.Append(c);
                }
                else
                {
                    stringBuilder.Append("%").Append(
                        string.Format(CultureInfo.InvariantCulture, "{0:X2}", (int)c));
                }
            }
            return stringBuilder.ToString();
        }
        public static string Encode(String value)
        {
            return HttpUtility.UrlEncode(value, Encoding.UTF8);
        }
    }
}

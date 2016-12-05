using System;
using System;
using System.Globalization;
using System.Security.Cryptography;

namespace AliCloudPush
{
    public class ParameterHelper
    {
        private const string ISO8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

        public static string FormatIso8601Date(DateTime date)
        {
            return date.ToUniversalTime().ToString(ISO8601_DATE_FORMAT, CultureInfo.CreateSpecificCulture("en-US"));
        }

        public static string GetRFC2616Date(DateTime datetime)
        {
            if (null == datetime)
            {
                datetime = DateTime.Now;
            }
            return datetime.ToUniversalTime().GetDateTimeFormats('r')[0].ToString();
        }

        public static string Md5Sum(byte[] buff)
        {
            MD5 md5 = new MD5CryptoServiceProvider();
            byte[] output = md5.ComputeHash(buff);
            return BitConverter.ToString(output).Replace("-", "");
        }

        public static string FormatTypeToString(FormatType? formatType)
        {
            if (FormatType.XML == formatType)
            {
                return "application/xml";
            }
            if (FormatType.JSON == formatType)
            {
                return "application/json";
            }
            return "application/octet-stream";
        }

        public static FormatType? StingToFormatType(string format)
        {
            if (format.ToLower().Equals("application/xml") || format.ToLower().Equals("text/xml"))
            {
                return FormatType.XML;
            }
            if (format.ToLower().Equals("application/json"))
            {
                return FormatType.JSON;
            }
            return FormatType.RAW;
        }

        public static MethodType? StringToMethodType(string method)
        {
            method = (method.ToUpper());
            switch (method)
            {
                case "GET":
                    {
                        return MethodType.GET;
                    }
                case "PUT":
                    {
                        return MethodType.PUT;
                    }
                case "POST":
                    {
                        return MethodType.POST;
                    }
                case "DELETE":
                    {
                        return MethodType.DELETE;
                    }
                case "HEAD":
                    {
                        return MethodType.HEAD;
                    }
                case "OPTIONS":
                    {
                        return MethodType.OPTIONS;
                    }
                default:
                    {
                        return null;
                    }
            }
        }

    }
}

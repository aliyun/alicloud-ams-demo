using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AliCloudPush
{
    public class DictionaryUtil
    {
        public static void Add<T>(Dictionary<string, string> dic, string key, T value)
        {
            if (null == value)
            {
                return;
            }
            if (dic == null)
            {
                dic = new Dictionary<string, string>();
            }
            else if (dic.ContainsKey(key))
            {
                dic.Remove(key);
            }
            dic.Add(key, value.ToString());
        }

        public static string Get(Dictionary<string, string> dic, string key)
        {
            if (dic.ContainsKey(key))
            {
                return dic[key];
            }
            return null;
        }

        public static string Pop(Dictionary<string, string> dic, string key)
        {
            string value = null;
            if (dic.ContainsKey(key))
            {
                value = dic[key];
                dic.Remove(key);
            }
            return value;
        }
    }
}


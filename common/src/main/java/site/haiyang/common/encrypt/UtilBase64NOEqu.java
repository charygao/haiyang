package site.haiyang.common.encrypt;//package site.haiyang.common.encrypt;
//
//public class UtilBase64NOEqu {
//    
//  /// <summary>自定义包含指定字符的base64工具</summary>
//        static String base64Table = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-";
//        static int[] base64Index = new int[]
//        {
//            -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//            -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//            -1,63,-1,-1,52,53,54,55,56,57,58,59,60,61,-1,-1,-1,-1,-1,-1,-1,0,1,
//            2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,-1,
//            -1,-1,-1,62,-1,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,
//            43,44,45,46,47,48,49,50,51,-1,-1,-1,-1,-1,-1
//        };
//        public static byte[] FromBase64String(String inData)
//        {
//            int inDataLength = inData.length();
//            int lengthmod4 = inDataLength % 4;
//            int calcLength = (inDataLength - lengthmod4);
//            byte[] outData = new byte[inDataLength / 4 * 3 + 3];
//            int j = 0;
//            int i;
//            int num1, num2, num3, num4;
//
//            for (i = 0; i < calcLength; i += 4, j += 3)
//            {
//                num1 = base64Index[inData[i]];
//                num2 = base64Index[inData[i + 1]];
//                num3 = base64Index[inData[i + 2]];
//                num4 = base64Index[inData[i + 3]];
//
//                outData[j] = (byte)((num1 << 2) | (num2 >> 4));
//                outData[j + 1] = (byte)(((num2 << 4) & 0xf0) | (num3 >> 2));
//                outData[j + 2] = (byte)(((num3 << 6) & 0xc0) | (num4 & 0x3f));
//            }
//            i = calcLength;
//            switch (lengthmod4)
//            {
//                case 3:
//                    num1 = base64Index[inData[i]];
//                    num2 = base64Index[inData[i + 1]];
//                    num3 = base64Index[inData[i + 2]];
//
//                    outData[j] = (byte)((num1 << 2) | (num2 >> 4));
//                    outData[j + 1] = (byte)(((num2 << 4) & 0xf0) | (num3 >> 2));
//                    j += 2;
//                    break;
//                case 2:
//                    num1 = base64Index[inData[i]];
//                    num2 = base64Index[inData[i + 1]];
//
//                    outData[j] = (byte)((num1 << 2) | (num2 >> 4));
//                    j += 1;
//                    break;
//            }
//            Array.Resize(ref outData, j);
//            return outData;
//        }
//        public static string ToBase64String(byte[] inData)
//        {
//            int inDataLength = inData.Length;
//            int outDataLength = (int)(inDataLength / 3 * 4) + 4;
//            char[] outData = new char[outDataLength];
//
//            int lengthmod3 = inDataLength % 3;
//            int calcLength = (inDataLength - lengthmod3);
//            int j = 0;
//            int i;
//
//            for (i = 0; i < calcLength; i += 3, j += 4)
//            {
//                outData[j] = base64Table[inData[i] >> 2];
//                outData[j + 1] = base64Table[((inData[i] & 0x03) << 4) | (inData[i + 1] >> 4)];
//                outData[j + 2] = base64Table[((inData[i + 1] & 0x0f) << 2) | (inData[i + 2] >> 6)];
//                outData[j + 3] = base64Table[(inData[i + 2] & 0x3f)];
//            }
//
//            i = calcLength;
//            switch (lengthmod3)
//            {
//                case 2:
//                    outData[j] = base64Table[inData[i] >> 2];
//                    outData[j + 1] = base64Table[((inData[i] & 0x03) << 4) | (inData[i + 1] >> 4)];
//                    outData[j + 2] = base64Table[(inData[i + 1] & 0x0f) << 2];
//                    j += 3;
//                    break;
//                case 1:
//                    outData[j] = base64Table[inData[i] >> 2];
//                    outData[j + 1] = base64Table[(inData[i] & 0x03) << 4];
//                    j += 2;
//                    break;
//            }
//            return new String(outData, 0, j);
//        }
//        public static String Base64Encode(String source)
//        {
//            byte[] barray = Encoding.Default.GetBytes(source);
//            return Base64Helper.ToBase64String(barray);
//        }
//        public static String Base64Decode(String source)
//        {
//            byte[] barray = Base64Helper.FromBase64String(source);
//            return Encoding.Default.GetString(barray);
//        }
//
//}

package udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class Unicode extends UDF{
    public static void main(String[] args) {
//    	Unicode uic = new Unicode();
//    	System.out.println(uic.evaluate(new Text("\\\\u4fdd\\\\u9669\\\\u90e8\\\\u6743\\\\u9650")));
//    	String cn = "�������Ȩ��";
//        System.out.println(cnToUnicode(cn));
        
        // �ַ��� : \u5f00\u59cb\u4efb\u52a1 ������ \ ��java����ת���ַ���Ҫд������������ʽ
        String unicode = "\\u4fdd\\u9669\\u90e8\\u6743\\u9650";
        System.out.println(unicodeToCn(unicode));
    }
    private static String unicodeToCn(String unicode) {
        /** �� \ u �ָ��Ϊjavaע��Ҳ��ʶ��unicode������м����һ���ո�*/
        String[] strs = unicode.split("\\\\u");
        String returnStr = "";
        // ����unicode�ַ����� \ u ��ͷ����˷ָ���ĵ�һ���ַ���""��
        for (int i = 1; i < strs.length; i++) {
          returnStr += (char) Integer.valueOf(strs[i], 16).intValue();
        }
        return returnStr;
    }
     
//    private static String cnToUnicode(String cn) {
//        char[] chars = cn.toCharArray();
//        String returnStr = "";
//        for (int i = 0; i < chars.length; i++) {
//          returnStr += "\\u" + Integer.toString(chars[i], 16);
//        }
//        return returnStr;
//    }
}
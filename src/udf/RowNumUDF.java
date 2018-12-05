package udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;
 
public class RowNumUDF extends UDF{
     
    public static String signature = "_";
    public static int order = 0;
     
    public int evaluate(Text text){
         
        if(text != null){
             
            //������������ݣ�������ͨ��Ϊ����
            String colName = text.toString();
             
            //�����һ������
            if(signature == "_"){
                 
                //���·���������ֶΣ�����������rownum��Ϊ1
                signature = colName;
                order = 1;
                 
                //����rownum
                return order;
            }else{
            //���ȱȶ��Ƿ����һ��������ͬ
            if(signature.equals(colName)){
                 
                //rownum���μ�1
                order++;
                return order;
            }else{
                    //��������ı䣬��rownum��Ϊ1
                    signature = colName;
                    order = 1;
                    return order;
                }
            }
        }else{
            //�������Ϊ�գ��򷵻�-1
            return -1;
        }
    }
}

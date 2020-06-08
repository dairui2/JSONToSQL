package udf;

import static org.junit.Assert.assertArrayEquals;

import javax.print.attribute.standard.MediaName;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

import edu.umd.cs.findbugs.annotations.NoWarning;
 
public class RowNumUDF extends UDF{
     
    private static final Text Text = null;
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
    
    public static void main(String[] args) {
    	RowNumUDF rn = new RowNumUDF();
		System.out.println(rn.evaluate(new Text( "zhangsan")));
	}
}

package udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.IntWritable;

import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.Text;

public class HelloUDF extends UDF{
/**
 * ����UDF������evaluate�Ĳ����ͷ���ֵ�����˽���ʹ��Writeabe
 * @param name
 * @return
 */
	public HelloUDF() {
		System.out.println("aaa");
	}
	public String evaluate(String name) {
		return new String("Hello: "+name);
		
	}
	
	
	public String evaluate(String name,int age) {
		return new String("Hello: "+name+", age: " +age);
		
	}
	
	
	public static void main(String[] args) {
		HelloUDF udf = new HelloUDF();
		System.out.println(udf.evaluate(new String("zhangsan")));
//		System.out.println(udf.evaluate(new String("zhangsan", new int(20))));
	}
}

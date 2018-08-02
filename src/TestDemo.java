import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Description: <br/>
 * Date:2018年8月1日 下午5:11:14 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */

public class TestDemo
{
	
	public static void main(String[] args) throws IOException, TemplateException
	{
		//配置对象
		Configuration conf = new Configuration();
		//模板所在文件夹路径
		conf.setDirectoryForTemplateLoading(new File("E:\\Development\\Codes\\eclipse_ws\\FreemarkerDemo1\\ftl"));
		//获取模板
		Template template = conf.getTemplate("template1.html");
		//数据根节点
		Map<String, Object> rootMap = new HashMap<>();
		//字符串数据
		rootMap.put("hello", "你好Freemarker！");
		
		//对象数据
		Person person = new Person();
		person.setId(UUID.randomUUID().toString());
		person.setName("张三");
		rootMap.put("person", person);
		
		//List集合数据
		List<Person> personList = new ArrayList<>();
		for (int i = 0; i < 3; i++)
		{
			Person personi = new Person();
			personi.setId(i+"");
			personi.setName("name"+i);
			personList.add(personi);
		}
		rootMap.put("personList", personList);
		
		//Map<String,String>集合数据
		Map<String,String> strMap = new HashMap<>();
		strMap.put("id1", "12311");
		strMap.put("name1", "aaabbb");
		rootMap.put("strMap", strMap);
		
		//获取List<Map<String,String>>集合数据
		List<Map<String,String>> strListMap = new ArrayList<>();
		Map<String,String> strMap1 = new HashMap<>();
		strMap1.put("id", "lid1");
		strMap1.put("name", "lname1");
		strListMap.add(strMap1);
		Map<String,String> strMap2 = new HashMap<>();
		strMap2.put("id", "lid2");
		strMap2.put("name", "lname2");
		strListMap.add(strMap2);
		rootMap.put("strListMap", strListMap);
		
		//输出流
		Writer writer = new FileWriter("F:\\hello.html");
		//生成静态页面
		template.process(rootMap, writer);
		
		writer.flush();
		writer.close();
		
		System.out.println("生成成功！");
		
	}

}

import com.baizhi.cmfz.dao.MenuListDao;
import com.baizhi.cmfz.entity.MenuList;
import com.baizhi.cmfz.service.RoundSowingService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2018/7/5.
 */
public class text {

    public static void main(String[] args) {
      //  ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        String s = UUID.randomUUID().toString().replace("-","");
        System.out.println(s);
    }
}

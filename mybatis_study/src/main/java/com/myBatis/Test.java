package com.myBatis;

import com.myBatis.entity.Account;
import com.myBatis.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class Test {
  public static void main(String[] args) throws IOException {
    // 第一步：读取 mybatis-config.xml 配置文件
    InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
    // 可以替换为下面这句
//    Test.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
    // 第二步：构建 sqlSessionFactory （框架初始化）
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    // 第三部：打开 sqlSession
    SqlSession session = sqlSessionFactory.openSession();
    // 第四步：获取 Mapper 接口对象（底层是动态代理）
    AccountMapper mapper = session.getMapper(AccountMapper.class);
    // 第五步：调用 Mapper 接口对象的方法操作数据库
    Account account = mapper.selectByPrimaryKey(1);
    // 第六步：业务处理
    log.debug("查询结果>>>:" + account.getId() + "--" + account.getRealname());
    // session 提交并关闭
    session.commit();
    session.close();
  }
}

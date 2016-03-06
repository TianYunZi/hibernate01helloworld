package org.ahhn.com.helloworld;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

/**
 * Created by XJX on 2016/3/6.
 */
public class HibernateTest {

	@Test
	public void test() {
		//1、创建一个SessionFactory对象
		SessionFactory sessionFactory = null;

		Configuration configuration = new Configuration().configure();

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		//2、创建Session对象
		Session session = sessionFactory.openSession();

		//3、开启事务
		Transaction transaction = session.beginTransaction();

		//4、执行保存事务
		Books books = new Books("1003", "C++", 130);
		session.save(books);

		//5、提交事务
		transaction.commit();

		//6、关闭Session对象
		session.close();

		//7、关闭SessionFactory对象
		sessionFactory.close();
	}
}

/*
 * Copyright 2011-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License
import org.springframework.aop.framework.Advised;
");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.jpa.repository.query;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.util.ReflectionTestUtils.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.ejb.HibernateQuery;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.sample.User;
import org.springframework.data.jpa.repository.support.PersistenceProvider;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.DefaultRepositoryMetadata;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Integration tests for {@link PartTreeJpaQuery}.
 * 
 * @author Oliver Gierke
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:infrastructure.xml")
public class PartTreeJpaQueryIntegrationTests {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * @see DATADOC-90
	 * @throws Exception
	 */
	@Test
	public void test() throws Exception {

		Method method = UserRepository.class.getMethod("findByFirstname", String.class, Pageable.class);
		JpaQueryMethod queryMethod = new JpaQueryMethod(method, new DefaultRepositoryMetadata(UserRepository.class),
				PersistenceProvider.fromEntityManager(entityManager));
		PartTreeJpaQuery jpaQuery = new PartTreeJpaQuery(queryMethod, entityManager);

		jpaQuery.createQuery(new Object[] { "Matthews", new PageRequest(0, 1) });
		jpaQuery.createQuery(new Object[] { "Matthews", new PageRequest(0, 1) });
	}

	@Test
	public void cannotIgnoreCaseIfNotString() throws Exception {

		thrown.expect(IllegalStateException.class);
		thrown.expectMessage("Unable to ignore case of java.lang.Integer types, the property 'id' must reference a String");
		testIgnoreCase("findByIdIgnoringCase", 3);
	}

	@Test
	public void cannotIgnoreCaseIfNotStringUnlessIgnoringAll() throws Exception {

		testIgnoreCase("findByIdAllIgnoringCase", 3);
	}

	/**
	 * @see DATAJPA-121
	 */
	@Test
	public void recreatesQueryIfNullValueIsGiven() throws Exception {

		Method method = UserRepository.class.getMethod("findByFirstname", String.class, Pageable.class);
		JpaQueryMethod queryMethod = new JpaQueryMethod(method, new DefaultRepositoryMetadata(UserRepository.class),
				PersistenceProvider.fromEntityManager(entityManager));
		PartTreeJpaQuery jpaQuery = new PartTreeJpaQuery(queryMethod, entityManager);

		Query query = jpaQuery.createQuery(new Object[] { "Matthews", new PageRequest(0, 1) });

		HibernateQuery hibernateQuery = getValue(query, "h.target.val$jpaqlQuery");
		assertThat(hibernateQuery.getHibernateQuery().getQueryString(), endsWith("firstname=:param0"));

		query = jpaQuery.createQuery(new Object[] { null, new PageRequest(0, 1) });

		hibernateQuery = getValue(query, "h.target.val$jpaqlQuery");
		assertThat(hibernateQuery.getHibernateQuery().getQueryString(), endsWith("firstname is null"));
	}

	private void testIgnoreCase(String methodName, Object... values) throws Exception {

		Class<?>[] parameterTypes = new Class[values.length];
		for (int i = 0; i < values.length; i++) {
			parameterTypes[i] = values[i].getClass();
		}
		Method method = UserRepository.class.getMethod(methodName, parameterTypes);
		JpaQueryMethod queryMethod = new JpaQueryMethod(method, new DefaultRepositoryMetadata(UserRepository.class),
				PersistenceProvider.fromEntityManager(entityManager));
		PartTreeJpaQuery jpaQuery = new PartTreeJpaQuery(queryMethod, entityManager);
		jpaQuery.createQuery(values);
	}

	@SuppressWarnings("unchecked")
	private static <T> T getValue(Object source, String path) {

		Iterator<String> split = Arrays.asList(path.split("\\.")).iterator();
		Object result = source;

		while (split.hasNext()) {
			result = getField(result, split.next());
		}

		return (T) result;
	}

	interface UserRepository extends Repository<User, Long> {

		Page<User> findByFirstname(String firstname, Pageable pageable);

		User findByIdIgnoringCase(Integer id);

		User findByIdAllIgnoringCase(Integer id);
	}
}

/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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
package org.springframework.data.jpa.support;

import static org.mockito.Mockito.*;

import javax.persistence.Entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor;

/**
 * Unit tests for {@link org.springframework.data.jpa.support.ClasspathScanningPersistenceUnitPostProcessor}.
 * 
 * @author Oliver Gierke
 */
@RunWith(MockitoJUnitRunner.class)
public class ClasspathScanningPersistenceUnitPostProcessorUnitTests {

	@Mock
	MutablePersistenceUnitInfo pui;
	String basePackage = getClass().getPackage().getName();

	@Test(expected = IllegalArgumentException.class)
	public void rejectsNullBasePackage() {
		new ClasspathScanningPersistenceUnitPostProcessor(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void rejectsEmptyBasePackage() {
		new ClasspathScanningPersistenceUnitPostProcessor("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void rejectsNullMappingFileNamePattern() {
		ClasspathScanningPersistenceUnitPostProcessor processor = new ClasspathScanningPersistenceUnitPostProcessor(
				basePackage);
		processor.setMappingFileNamePattern(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void rejectsEmptyMappingFileNamePattern() {
		ClasspathScanningPersistenceUnitPostProcessor processor = new ClasspathScanningPersistenceUnitPostProcessor(
				basePackage);
		processor.setMappingFileNamePattern("");
	}

	@Test
	public void findsEntityClassesForBasePackage() {

		PersistenceUnitPostProcessor processor = new ClasspathScanningPersistenceUnitPostProcessor(basePackage);
		processor.postProcessPersistenceUnitInfo(pui);

		verify(pui).addManagedClassName(SampleEntity.class.getName());
	}

	@Test
	public void findsMappingFile() {

		DefaultResourceLoader loader = new DefaultResourceLoader();
		String expected = getClass().getResource("mapping.xml").toString();

		ClasspathScanningPersistenceUnitPostProcessor processor = new ClasspathScanningPersistenceUnitPostProcessor(
				basePackage);
		processor.setMappingFileNamePattern("*.xml");
		processor.setResourceLoader(loader);
		processor.postProcessPersistenceUnitInfo(pui);

		verify(pui).addManagedClassName(SampleEntity.class.getName());
		verify(pui).addMappingFileName(expected);
	}

	@Entity
	public static class SampleEntity {

	}
}

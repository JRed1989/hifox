package org.edf.hifox.security.support;

import javax.annotation.Resource;

import org.edf.hifox.core.editor.ClassEditor;
import org.edf.hifox.security.cipher.Decipher;
import org.edf.hifox.security.cipher.Encipher;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:framework/spring/*-applicationContext.xml"})
public class AESCipherTest {
	
	@Resource(name = "aesEncipher")
	private Encipher encipher;
	
	@Resource(name = "aesDecipher")
	private Decipher decipher;
	
	@SuppressWarnings("unchecked")
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String className = "org.edf.hifox.core.editor.Log4jClassEditor";
		Class<ClassEditor> clazz = (Class<ClassEditor>) Class.forName(className);
		ClassEditor classEditor = clazz.newInstance();
		classEditor.edit();
	}

	@Test
	public void testEncryptDecrypt() throws Exception {
		long time = System.currentTimeMillis();
		
		String str = encipher.encrypt("abcd你好abcd你好");
		System.out.println("encrypt:" + str);
		
		str = decipher.decrypt(str);
		System.out.println("decrypt:" + str);
		
		System.out.println("time:" + (System.currentTimeMillis() - time));
	}

}

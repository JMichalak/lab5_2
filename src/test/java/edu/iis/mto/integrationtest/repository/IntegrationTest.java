package edu.iis.mto.integrationtest.repository;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.iis.mto.integrationtest.config.ApplicationConfig;
import edu.iis.mto.integrationtest.utils.Mode;
import edu.iis.mto.integrationtest.utils.ModeUtils;
@ContextConfiguration(classes = { ApplicationConfig.class }) //kontekst Spring
@RunWith(SpringJUnit4ClassRunner.class) // uruchamianie z wykorzystaniem specyficznego wykonawcy
public class IntegrationTest {

	@BeforeClass
	public static void setUpMode() {
		ModeUtils.setMode(Mode.TEST);
	}
}

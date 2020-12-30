package cn.itcast.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;



public class TestLog {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Log log =LogFactory.getLog(getClass());
		log.debug("debug jibie");
		log.info("info jibie");
		log.warn("warn jibie");
		log.error("error jibie");
		log.fatal("fatal jibie");
	}

}

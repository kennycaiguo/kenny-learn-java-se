package cn.kenny.ws.jobtest;

import jdk.nashorn.api.scripting.JSObject;
import cn.kenny.ws.job.JobService;
import cn.kenny.ws.job.JobServiceImplService;

public class TestJobService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       JobServiceImplService jsi=new JobServiceImplService();
       JobService jobService = jsi.getJobServiceImplPort();
       String job = jobService.getJob();
       String[] jobs=job.split("\\|");
       for (String string : jobs) {
		System.out.println(string );
	 }
	}

}

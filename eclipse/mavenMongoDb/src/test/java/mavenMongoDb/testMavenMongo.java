package mavenMongoDb;

import org.junit.Test;

public class testMavenMongo {
    @Test
    public void testFindAllData() {
    	MavenMongoDemo mmd=new MavenMongoDemo();
    	mmd.findAll();
    }
	
    @Test
    public void testFindByNum() {
    	MavenMongoDemo mmd=new MavenMongoDemo();
    	int num=7499;
    	mmd.findByNum(num);
    }
    
    @Test
    public void testAdd() {
    	MavenMongoDemo mmd=new MavenMongoDemo();
    	mmd.insertOneData();
    }
    
    @Test
    public void testAddMany() {
    	
    	MavenMongoDemo mmd=new MavenMongoDemo();
    	mmd.insertManyDatas();
    	
    }
    
    @Test
    public void testUpdate() {
    	MavenMongoDemo mmd=new MavenMongoDemo();
    	mmd.UpdateData();
    }
    
    @Test
    public void testDelete() {
    	MavenMongoDemo mmd=new MavenMongoDemo();
    	mmd.delData();
    }
}

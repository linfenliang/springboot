package com.springboot.data.mongodb;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StopWatch;

import com.springboot.data.mongodb.MongodbApp;
import com.springboot.data.mongodb.dao.VehicleOnlineDataRepository;
import com.springboot.data.mongodb.domain.VehicleOnlineData;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=MongodbApp.class)
//@Transactional
public class MongodbAppTest {
	@Autowired
	private VehicleOnlineDataRepository repository;
//	@Autowired
//	private MongoTemplate mongoTemplate;
	static Date gatherTimeBegin;
	static Date gatherTimeEnd;
	String vehicleId = "98765432109876543210987654321747";
	static{
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 06, 04, 11, 20, 00);
		cal.set(Calendar.MILLISECOND,000);
		gatherTimeBegin = cal.getTime();
		cal.set(2017, 06, 04, 11, 20, 50);
		cal.set(Calendar.MILLISECOND,000);
		gatherTimeEnd = cal.getTime();
	}
	
	
	/**
	 * Rigourous Test :-)
	 */
	@Test
	public void testApp() {
		assertTrue(true);
	}
//	@Test
//	public void mongoTemplateTest(){
//		StopWatch watch = new StopWatch();
//		watch.start("mongotemplate query");
//		Query condition = new Query(Criteria.where("vehicleId").is(vehicleId)
//				//.andOperator
//				).addCriteria(
//				(Criteria.where("gatherTime").gte(gatherTimeBegin).lt(gatherTimeEnd))
//				).with(new PageRequest(0, 10,new Sort(Direction.DESC,"gatherTime"))).limit(10);
//		List<VehicleOnlineData> page = mongoTemplate.find(condition, VehicleOnlineData.class);
//		System.out.println(page);
//		page.forEach(v->{System.out.println(ReflectionToStringBuilder.toString(v));});
//		watch.stop();
//		System.out.println(watch.prettyPrint());
//		watch.start("mongotemplate count");
//		System.out.println("mongoTemplate count:"+mongoTemplate.count(condition, VehicleOnlineData.class));
//		watch.stop();
//		System.out.println(watch.prettyPrint());
//	}
	@Test
	public void repositoryTest(){
		StopWatch watch = new StopWatch();
		watch.start("query by condition");
		Page<VehicleOnlineData> page = repository.findByVehicleIdAndGatherTimeRange(vehicleId, gatherTimeBegin, gatherTimeEnd, new PageRequest(0, 10,new Sort(Direction.DESC,"gatherTime")));
		page.forEach(v->{
			System.out.println(ReflectionToStringBuilder.toString(v));
		});
		watch.stop();
		watch.start("get page info");
		System.out.println("repository:"+ReflectionToStringBuilder.toString(page));
		watch.stop();
		System.out.println(watch.prettyPrint());
		
	}
//	@org.junit.Ignore
	@Test
	public void add1000WDataTest() throws InterruptedException, ExecutionException{
		int inserTotal = 10_000_000;
		final int batchSize = 5000;
		ExecutorService es = Executors.newFixedThreadPool(8);
		StopWatch watch = new StopWatch();
		watch.start();
		AtomicInteger count = new AtomicInteger((int) repository.count());
		final int cycleSize = inserTotal/batchSize;
		List<Future<Boolean>> futureList = new ArrayList<>();  
		for(int i =0 ;i<cycleSize;i++){
			futureList.add(es.submit(new Thread(){
				@Override
				public void run() {
					List<VehicleOnlineData> list = new ArrayList<>();
					for(int j=0;j<batchSize;j++){
						list.add(getBean());
					}
					List<VehicleOnlineData> v = repository.save(list);
					System.out.println(Thread.currentThread().getId()+"线程 ，总数据量：    "+count.addAndGet(batchSize)+"  ，当前保存记录数：    "+v.size());
				}
			},true));
		}
		for(Future<Boolean> f:futureList){
			f.get();
		}
		watch.stop();
		System.out.println(watch.prettyPrint());
		es.shutdown();
	}
	private VehicleOnlineData getBean(){
		VehicleOnlineData vod = new VehicleOnlineData();
		vod.setAccStatus(1);
		vod.setAltitude(RandomUtils.nextInt(0, 1000));
		vod.setDirect(RandomUtils.nextInt(0, 360));
		vod.setGatherTime(new Date());
		vod.setGpsSpeed(RandomUtils.nextInt(0, 120));
		vod.setHumidometerProbe1(RandomUtils.nextDouble(0.1, 0.99));
		vod.setHumidometerProbe2(RandomUtils.nextDouble(0.1, 0.99));
		vod.setHumidometerProbe3(RandomUtils.nextDouble(0.1, 0.99));
		vod.setHumidometerProbe4(RandomUtils.nextDouble(0.1, 0.99));
		vod.setOffsetLatitude(RandomUtils.nextDouble(60.1, 65.9));
		vod.setOffsetLongitude(RandomUtils.nextDouble(110.1, 125.1));
		vod.setRealLatitude(vod.getOffsetLatitude());
		vod.setRealLongitude(vod.getOffsetLongitude());
		vod.setThermometerProbe1(RandomUtils.nextInt(0, 38));
		vod.setThermometerProbe2(RandomUtils.nextInt(0, 38));
		vod.setThermometerProbe3(RandomUtils.nextInt(0, 38));
		vod.setThermometerProbe4(RandomUtils.nextInt(0, 38));
		String randomInt = RandomStringUtils.randomNumeric(3);
		vod.setVehicleId("98765432109876543210987654321"+randomInt);
		vod.setVehicleNo("京HM831"+randomInt);
		vod.setCreateDate(new Date());
		vod.setUpdateDate(vod.getCreateDate());
		vod.setDelFlag("0");
		vod.setCreateBy("linfenliang");
		vod.setUpdateBy(vod.getCreateBy());
		return vod;
		
	}
	
	
}

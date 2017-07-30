package com.springboot.data.mongodb;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.StopWatch;

import com.springboot.data.mongodb.dao.VehicleOnlineDataRepository;
import com.springboot.data.mongodb.domain.VehicleOnlineData;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner{
	@Autowired
	private VehicleOnlineDataRepository repository;
//	private ExecutorService es = Executors.newFixedThreadPool(4);
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(repository.count());
//		Thread.sleep(3000);
//		repository.deleteAll();
//		VehicleOnlineData vod = new VehicleOnlineData();
//		vod.setVehicleNo("京HM8310");
//		vod.setVehicleId("123456");
//		VehicleOnlineData v = repository.save(vod);
//		System.out.println(v.getId());
//		System.out.println(ReflectionToStringBuilder.toString(repository.findByVehicleId("123456").get(0)));
		StopWatch watch = new StopWatch();
		watch.start();
//		AtomicInteger count = new AtomicInteger((int) repository.count());
//		final int batchSize = 1;
//		final int cycleSize = 439/batchSize;
//		List<Future<Boolean>> futureList = new ArrayList<>();  
//		for(int i =0 ;i<cycleSize;i++){
//			futureList.add(es.submit(new Thread(){
//				@Override
//				public void run() {
//					List<VehicleOnlineData> list = new ArrayList<>();
//					for(int j=0;j<batchSize;j++){
//						list.add(getBean());
//					}
//					List<VehicleOnlineData> v = repository.save(list);
//					System.out.println(Thread.currentThread().getId()+"     "+count.addAndGet(batchSize)+"      "+v.size());
//				}
//			},true));
//		}
//		for(Future<Boolean> f:futureList){
//			f.get();
//		}
//		Thread.sleep(60*1000);
		
//		List<VehicleOnlineData> vList = repository.findByVehicleId("987654321098765432109876543210320");
//		vList.forEach(v->{System.out.println(ReflectionToStringBuilder.toString(v));});
//		for(int i=0;i<1;i++){
//			System.out.println(i+":"+repository.countByVehicleId("98765432109876543210987654321032"+i));
//		}
		Pageable pageable = new PageRequest(0, 10, Direction.ASC,"gatherTime");
		Page<VehicleOnlineData> page = repository.findAll(pageable);
		page.forEach(v->{
			System.out.println(v.getGatherTime()+":"+ReflectionToStringBuilder.toString(v));
		});
		repository.save(getBean());
		pageable = new PageRequest(0, 10,new Sort(Direction.DESC,"createDate"));
		page = repository.findAll(pageable);
		page.forEach(v->{
			System.out.println(v.getGatherTime()+":"+ReflectionToStringBuilder.toString(v));
		});
//		VehicleOnlineData query = new VehicleOnlineData();
//		query.setVehicleId("98765432109876543210987654321032A");
//		query.setGatherTime(new Date);
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 5, 14, 18, 22, 18);
		Date gatherTimeBegin = cal.getTime();
		cal.add(Calendar.SECOND, 30);
		Date gatherTimeEnd = cal.getTime();
		page = repository.findByVehicleIdAndGatherTimeRange("98765432109876543210987654321032A", gatherTimeBegin, gatherTimeEnd,new PageRequest(0, 10,new Sort(Direction.DESC,"gatherTime")));
		System.out.println("page obj:"+ReflectionToStringBuilder.toString(page));
		page.forEach(v->{
			System.out.println("matcher:"+v.getGatherTime()+":"+ReflectionToStringBuilder.toString(v));
		});
//		
//		Query condition = new Query(Criteria.where("vehicleId").is("98765432109876543210987654321032A")
//				.andOperator(Criteria.where("gatherTimeBegin").gte(gatherTimeBegin),Criteria.where("gatherTimeEnd").lt(gatherTimeEnd)));
//		repository.findAll(condition);
		
		watch.stop();
		System.out.println(watch.prettyPrint());
		System.out.println(repository.count());
//		es.shutdown();
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
		String randomInt = RandomStringUtils.randomNumeric(1);
		vod.setVehicleId("98765432109876543210987654321032"+randomInt);
		vod.setVehicleNo("京HM831"+randomInt);
		vod.setCreateDate(new Date());
		vod.setUpdateDate(vod.getCreateDate());
		vod.setDelFlag("0");
		vod.setCreateBy("linfenliang");
		vod.setUpdateBy(vod.getCreateBy());
		return vod;
		
	}
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
}

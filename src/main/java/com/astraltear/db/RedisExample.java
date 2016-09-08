package com.astraltear.db;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisExample {

	public static void main(String[] args) {
		JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "1.201.137.62");
		Jedis jedis = jedisPool.getResource();

		try {
			
			// all flush
			String retVal= jedis.flushAll();
			System.out.println("retVal:"+retVal);
			
			// basic
			jedis.set("test1", "ASTRALTEAR");
			jedis.set("한글", "테스트");
			
			System.out.println("test1:" + jedis.get("test1"));
			System.out.println("한글:" + jedis.get("한글"));
			System.out.println(jedis.echo("echo"));
			
			// type check
			System.out.println("typeOF:"+jedis.type("test1")  );
			System.out.println("typeOF:"+jedis.type("한글")  );
			
			// key exist
			System.out.println("key exist:"+jedis.exists("sdfrewre"));
			System.out.println("key exist array:"+jedis.exists("abc","bdef","test1"));
			
			// key overwrite
			jedis.set("test1", "덮어쓰기");
			System.out.println("test1:" + jedis.get("test1"));

			// key expire
			jedis.set("test2", "astraltear@gmail.com");
			jedis.expire("test2", 1000); // 해당 입력하는 값은 초 단위임
			System.out.println("test2:" + jedis.get("test2"));
			
			// key delete
			jedis.del("test2");
			System.out.println("test2 delete :" + jedis.get("test2"));
			
			
			// 먼저 값을 set한 후에 해당 key에 대한 값을 얻어온다 
			System.out.println("getSet1:"+ jedis.getSet("aloe", "vera") );		// getSet1:null
			System.out.println("getSet2:"+ jedis.getSet("aloe", "soothing") );	// getSet2:vera
			System.out.println("getSet3:"+ jedis.getSet("aloe", "gel") );		// getSet3:soothing
			System.out.println("getSet4:"+ jedis.get("aloe") );					// getSet4:gel
			
			// value append
			jedis.set("linux", "centos");
			System.out.println(jedis.get("linux"));
			jedis.append("linux", " 7.2");
			System.out.println(jedis.get("linux"));
			
			// 모든 키 가져오기 
			Set<String> set = jedis.keys("*");
			Iterator<String> iterator =  set.iterator();
			
			while (iterator.hasNext()) {
				System.out.println("iterator:"+(String) iterator.next());
			}

			
			// redis config get 
			List<String> configList = jedis.configGet("*");
			for (String key : configList) {
				System.out.println(key);
			}
			
			// increase count
			jedis.set("count", "0");
			jedis.incr("count");	// 1
			jedis.incr("count");	// 2
			jedis.incr("count");	// 3
			jedis.incr("count");	// 4
			jedis.incr("count");	// 5
			jedis.incr("count");	// 6
			jedis.incr("count");	// 7
			jedis.decr("count");	// 6
			jedis.incrBy("count", 3); // 9
			jedis.decrBy("count", 2);	// 7
			jedis.decrBy("count", 2);	// 5
			jedis.decrBy("count", 2);	// 3
			String count = jedis.get("count");
			System.out.println("count:"+count);
			
			
			System.out.println("count type:"+jedis.type("count"));
			
			// LIFO
			jedis.lpush("l-list", "Redis");
			jedis.lpush("l-list", "Mongodb");
			jedis.lpush("l-list", "Mysql");

			List<String> list = jedis.lrange("l-list", 0, jedis.llen("l-list"));
			for (int i = 0; i < list.size(); i++) {
				System.out.println("Stored string in l-list:: " + list.get(i));
			}
			
			// FIFO
			jedis.rpush("r-list", "Redis");
			jedis.rpush("r-list", "Mongodb");
			jedis.rpush("r-list", "Mysql");
			
			list = jedis.lrange("r-list", 0, jedis.llen("r-list"));
			for (int i = 0; i < list.size(); i++) {
				System.out.println("Stored string in r-list:: " + list.get(i));
			}
			
			// list
			jedis.mset("first","1","second","2","third","교사가","fourth","바뀌는","fifth","교육법","sixth","견적표");

			list = jedis.mget("first");
			for (String string : list) {
				System.out.println("first list:"+string);
			}
			
			list = jedis.mget("fourth");
			for (String string : list) {
				System.out.println("fourth list:"+string);
			}
			
			// hash??? 
			jedis.hset("cigar", "bohem", "1");
			jedis.hset("cigar", "bohem", "what is ");
			
			System.out.println("hget1:"+  jedis.hget("cigar", "bohem") );		// hget1:what is
			System.out.println("hget2:"+  jedis.hget("cigar", "boh") );			// hget2:null
			System.out.println("hexists:"+  jedis.hexists("cigar", "boh") );	// hexists:false
			System.out.println("hlen:"+  jedis.hlen("cigar") );					// hlen:1
			System.out.println("del:"+  jedis.hdel("cig", "boh") );				// del:0  삭제되지 않았다. key가 틀리지니까.
			System.out.println("del:"+  jedis.del("cigar", "boh") );			// del:1 삭제 완료 
			System.out.println("hget1:"+  jedis.hget("cigar", "bohem") );		// hget1:null 키가 삭제되었으므로 결과과 없다 
			
			jedis.hset("user1", "id", "abc");
			jedis.hset("user1", "email", "abc@abc.com");
			jedis.hset("user1", "tel", "1234");
			jedis.hset("user1", "tel", "5678");
			
			Set<String> userSet = jedis.hkeys("user1");
			
			Iterator<String> iterator2 = userSet.iterator();
			while (iterator2.hasNext()) {
				String key = (String) iterator2.next();
				System.out.println("user1 key::"+key);
			}
			
			List<String> userList = jedis.hvals("user1");
			
			for (String string : userList) {
				System.out.println("user1 vals::"+string);
			}
			
			Map<String, String> userMap = jedis.hgetAll("user1");
			
			userSet = userMap.keySet();
			iterator2 = userSet.iterator();
			
			while (iterator2.hasNext()) {
				String key = (String) iterator2.next();
				System.out.println("hgetAll::key["+key+"]value["+userMap.get(key)+"]");
			}
			

			// map handle
			Map<String, String> map = new HashMap<>();
			map.put("key1", "public");
			map.put("key2", "session");
			map.put("key3", "store");
			map.put("key4", "linux");
			map.put("key4", "windwos 2003");
			
			jedis.hmset("userMap", map);
			
			System.out.println("hmget:key5:"+ jedis.hmget("userMap", "key5"));		// key5는 존재하지 않는다 hmget:key5:[null]
			System.out.println("hmget:key4:"+ jedis.hmget("userMap", "key4"));		// hmget:key4:[windwos 2003]
			System.out.println("hmget:key3:"+ jedis.hmget("userMap", "key3"));		// hmget:key3:[store]
			System.out.println("typeOF:"+jedis.type("userMap")  );					// typeOF:hash
			
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
			if (jedis != null) {
				jedisPool.returnBrokenResource(jedis);
				jedis = null;
			}
		} finally {
			if (jedis != null) {
				jedisPool.returnResource(jedis);
			}
		}

		jedisPool.destroy();
	}

}